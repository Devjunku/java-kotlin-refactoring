package hello.corekotlin.order.implement

import hello.corekotlin.discount.DiscountPolicy
import hello.corekotlin.member.repository.MemberRepository
import hello.corekotlin.order.data.Order
import hello.corekotlin.order.service.OrderService

class OrderServiceImpl(
    private val memberRepository: MemberRepository,
    private val discountPolicy: DiscountPolicy
): OrderService {

    override fun createOrder(memberId: Long, itemName: String, itemPrice: Int): Order {
        val member = memberRepository.findById(memberId)
        val discountPrice = discountPolicy.discount(member, itemPrice)

        return Order(
            memberId,
            itemName,
            itemPrice,
            discountPrice
        )
    }

    fun getMemberRepository(): MemberRepository  {
        return memberRepository
    }

}