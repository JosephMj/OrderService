internal class MailService {
    private var price = PriceDetails()
    fun successMessage() {
        println("\nYour order is successful. Estimated Delivery time is: " + price.deliveryTime + " minutes\n")
    }

    fun errorMessage(msg: String?) {
        if (msg != null) {
            print(msg + "\n")
        } else {
            println("Something went wrong, please try again.")
        }
    }
}