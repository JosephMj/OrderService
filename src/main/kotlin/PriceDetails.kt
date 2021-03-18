class PriceDetails {
    private val appleCost = 0.60f
    private val orangeCost = 0.65f
    fun calculatePrice(appleCount: Int, orangeCount: Int): Float {
        return appleCount * appleCost + orangeCount * orangeCost
    }

}