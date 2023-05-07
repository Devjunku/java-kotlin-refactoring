package hello.corekotlin.order.data

data class Order(
    var memberId: Long,
    var itemName: String,
    var itemPrice: Int,
    var discountPrice: Int
) {
    fun calculatePrice(): Int = itemPrice - discountPrice
}