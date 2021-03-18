internal class PriceDetails {
    private val appleCost = 0.60f
    private val orangeCost = 0.65f
    var appleStock = 20
    var orangeStock = 15
    val deliveryTime = 20f

    fun calculatePrice(appleCount: Int, orangeCount: Int): Float {
        return appleCount * appleCost + orangeCount * orangeCost
    }

    fun calculateDiscount(appleCount: Long, orangeCount: Long): Float {

        val appleDisc = (appleCount / 2 + appleCount % 2) * appleCost
        val orangeDisc = (2 * (orangeCount / 3) + orangeCount % 3) * orangeCost
        return appleDisc + orangeDisc
    }

}