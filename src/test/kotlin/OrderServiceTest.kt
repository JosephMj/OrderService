import org.junit.Assert
import org.junit.Test
import kotlin.math.roundToLong

internal class OrderServiceTest {
    private val price = PriceDetails()
    @Test
    fun testSuccessTotal() {

        val totalPrice1 = price.calculatePrice(10, 10)
        Assert.assertEquals(12.5f, totalPrice1)
        val totalPrice2 = price.calculatePrice(1, 2)
        Assert.assertEquals(1.9f, totalPrice2)
        val totalPrice4 = price.calculatePrice(51, 17)
        Assert.assertEquals(41.65f, totalPrice4)
        val totalPrice5 = price.calculatePrice(0, 0)
        Assert.assertEquals(0f, totalPrice5)
    }

    @Test
    fun testSuccessDisc() {

        val discountAmount1 = price.calculateDiscount(10, 10)
        Assert.assertEquals(7.55f, ((discountAmount1 * 100.0).roundToLong() / 100.0).toFloat())
        val discountAmount2 = price.calculateDiscount(1, 2)
        Assert.assertEquals(1.9f, ((discountAmount2 * 100.0).roundToLong() / 100.0).toFloat())
        val discountAmount3 = price.calculateDiscount(51, 17)
        Assert.assertEquals(23.4f, ((discountAmount3 * 100.0).roundToLong() / 100.0).toFloat())
        val discountAmount4 = price.calculateDiscount(0, 0)
        Assert.assertEquals(0f, ((discountAmount4 * 100.0).roundToLong() / 100.0).toFloat())
     }

    @Test(expected = NumberFormatException::class)
    fun testFailureTotal() {
        price.calculatePrice("abc".toInt(), 10)
        price.calculatePrice(11, -5)
    }


    @Test(expected = NumberFormatException::class)
    fun testFailureDiscount() {
        price.calculateDiscount("abc".toLong(), 10)
        price.calculateDiscount(11, -5)
    }


}