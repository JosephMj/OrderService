import java.util.*
import kotlin.math.roundToLong


fun main() {

    val myObj = Scanner(System.`in`) // Create a Scanner object
    val price = PriceDetails()
    val mail = MailService()
    val topic=KafkaProducer()
    println("Items Available:\n Apples (0.6$/piece) | Stock: " + price.appleStock + "\n Oranges(0.65$/piece)| Stock: " + price.orangeStock + "\n Available Discounts-\n\tBuy one get one free on apples!!\n\t3 for the price of 2 on oranges!!\nEnter any key to continue or n to Exit")
    var choice = myObj.nextLine()
    while (!choice.equals("n", ignoreCase = true)) {
        try {
            println("Enter number of Apples required:")
            val apples = myObj.nextLine().toInt()
            if (apples < 0) throw Exception("Negative number")
            println("Enter number of Oranges required:")
            val oranges = myObj.nextLine().toInt()
            if (oranges < 0) throw Exception("Negative number")
            if (price.appleStock < apples) {
                throw Exception("Apples are out of Stock")
            }
            if (price.orangeStock < oranges) {
                throw Exception("Oranges are out of Stock")
            }
            val totalAmount = price.calculatePrice(apples, oranges)
            val discountAmount = price.calculateDiscount(apples.toLong(), oranges.toLong())
            price.appleStock = price.appleStock - apples
            price.orangeStock = price.orangeStock - oranges
            mail.successMessage()

            val kafkaMsg = "$apples,$oranges"
            topic.produce(kafkaMsg)

            println("Order Summary\n------------------------\n------------------------\nNumber of Apples  = $apples\nNumber of Oranges = $oranges")
            println("Total Price       = " + (totalAmount * 100.0).roundToLong() / 100.0 + "$")
            println("Discount amount   = " + ((totalAmount - discountAmount) * 100.0).roundToLong() / 100.0 + "$")
            println("Net Amount        = " + (discountAmount * 100.0).roundToLong() / 100.0 + "$")
            println("-----------------------------------------------\n")
            println("Remaining Stock-\nApples:  " + price.appleStock + "\nOranges: " + price.orangeStock)

            if (price.appleStock == 0 && price.orangeStock == 0) {
                mail.errorMessage("Sorry Stocks are fully over")
                choice = "n"
            } else {
                println("Enter n to exit / Enter any key to continue")
                myObj.nextLine()
            }
        } catch (e: Exception) {
            mail.errorMessage(e.message + " ,Order Failed due to Invalid Input")
            println("Enter n to exit / Enter any key to continue  ")
            choice = myObj.nextLine()
        }
    }
    println("Exiting program")
}
