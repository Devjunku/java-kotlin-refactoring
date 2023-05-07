package hello.corekotlin

import hello.corekotlin.discount.DiscountPolicy
import hello.corekotlin.discount.implement.RateDiscountPolicy
import hello.corekotlin.member.repository.MemberRepository
import hello.corekotlin.member.repository.MemoryMemberImpl
import hello.corekotlin.member.service.MemberService
import hello.corekotlin.member.service.MemberServiceImpl
import hello.corekotlin.order.implement.OrderServiceImpl
import hello.corekotlin.order.service.OrderService

class AppConfig {

    fun memberService(): MemberService = MemberServiceImpl(memberRepositoy())

    fun orderService(): OrderService = OrderServiceImpl(
        memberRepositoy(),
        discountPolicy()
    )

    fun memberRepositoy(): MemberRepository = MemoryMemberImpl()

    fun discountPolicy(): DiscountPolicy = RateDiscountPolicy()

}