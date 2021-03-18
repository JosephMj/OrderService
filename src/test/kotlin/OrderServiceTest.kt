import org.junit.Assert
import org.junit.Test

internal class OrderServiceTest {
    private val price = PriceDetails()
    @Test
    fun testSuccess() {

        val totalPrice1 = price.calculatePrice(10, 10)
        Assert.assertEquals(12.5f, totalPrice1)
        val totalPrice2 = price.calculatePrice(1, 2)
        Assert.assertEquals(1.9f, totalPrice2)
        val totalPrice4 = price.calculatePrice(51, 17)
        Assert.assertEquals(41.65f, totalPrice4)
        val totalPrice5 = price.calculatePrice(0, 0)
        Assert.assertEquals(0f, totalPrice5)
    }


    @Test(expected = NumberFormatException::class)
    fun testFailure() {
        price.calculatePrice("abc".toInt(), 10)
        price.calculatePrice(11, -5)
    }

}