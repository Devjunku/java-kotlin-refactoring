package hello.corekotlin.order.service

import hello.corekotlin.order.data.Order

interface OrderService {

    fun createOrder(memberId: Long, itemName: String, itemPrice: Int): Order

}