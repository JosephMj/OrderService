import java.util.*
import kotlin.math.roundToLong


fun main() {

    val myObj = Scanner(System.`in`) // Create a Scanner object
    val price = PriceDetails()
    println("Items Available:\n Apples (0.6$/piece)\n Oranges(0.65$/piece)\n Available Discounts-\n\tBuy one get one free on apples!!\n\t3 for the price of 2 on oranges!!\nEnter any key to continue or n to Exit")
    var choice = myObj.nextLine()
    while (!choice.equals("n", ignoreCase = true)) {
        try {
            println("Enter number of Apples required:")
            val apples = myObj.nextLine().toInt()
            if (apples < 0) throw NumberFormatException("Negative number")

            println("Enter number of Oranges required:")
            val oranges = myObj.nextLine().toInt()
            if (oranges < 0) throw NumberFormatException("Negative number")

            val totalAmount = price.calculatePrice(apples, oranges)

            println("Order Summary\n------------------------\n------------------------\nNumber of Apples  = $apples\nNumber of Oranges = $oranges")
            println("Total Price       = " + (totalAmount * 100.0).roundToLong() / 100.0 + "$")
            println("Enter n to exit / Enter any key to continue")
            choice = myObj.nextLine()
        } catch (e: NumberFormatException) {
            println(e.message + " is an Invalid input, Please Enter a valid number")
            println("Enter n to exit / Enter any key to continue  ")
            choice = myObj.nextLine()
        }
    }
    println("exiting program")
}
