class MailService {
    private var price = PriceDetails()
    fun successMessage() {
        println("\nYour order is successful. Estimated Delivery time is: " + price.deliveryTime + " minutes\n")
    }

    fun errorMessage(msg: String?) {
        if (!msg.equals(null)) {
            println("$msg,Order Failed due to Invalid Input\n")
        } else {
            println("Something went wrong, please try again.")
        }
    }
}