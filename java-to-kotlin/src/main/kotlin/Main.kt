fun main(args: Array<String>) {
    val customerEmailAddress = EmailAddress(
        "localPart",
        "localPart@domain"
    )
    val postMasterEmail = customerEmailAddress.copy(localPart = "postmaster")

}
