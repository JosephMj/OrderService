import java.util.*
import kotlin.math.roundToLong


fun main() {
    val myObj = Scanner(System.`in`) // Create a Scanner object
    val price = PriceDetails()
    val mail = MailService()
    println("Items Available:\n Apples (0.6$/piece)\n Oranges(0.65$/piece) \n Available Discounts-\n\tBuy one get one free on apples!!\n\t3 for the price of 2 on oranges!!\nEnter any key to continue or n to Exit")
    var choice = myObj.nextLine()
    while (!choice.equals("n", ignoreCase = true)) {
        try {
            println("Enter number of Apples required:")
            val apples = myObj.nextLine().toInt()
            if (apples < 0) throw Exception("Negative number")
            println("Enter number of Oranges required:")
            val oranges = myObj.nextLine().toInt()
            if (oranges < 0) throw Exception("Negative number")
            val totalAmount = price.calculatePrice(apples, oranges)
            val discountAmount = price.calculateDiscount(apples.toLong(), oranges.toLong())
            mail.successMessage()
            println("Order Summary\n------------------------\n------------------------\nNumber of Apples  = $apples\nNumber of Oranges = $oranges")
            println("Total Price       = " + (totalAmount * 100.0).roundToLong() / 100.0 + "$")
            println("Discount amount   = " + ((totalAmount - discountAmount) * 100.0).roundToLong() / 100.0 + "$")
            println("Net Amount        = " + (discountAmount * 100.0).roundToLong() / 100.0 + "$")
            println("Enter n to exit / Enter any key to continue")
            choice = myObj.nextLine()
        } catch (e: Exception) {
            mail.errorMessage(e.message)
            println("Enter n to exit / Enter any key to continue  ")
            choice = myObj.nextLine()
        }
    }
    println("Exiting program")
}
