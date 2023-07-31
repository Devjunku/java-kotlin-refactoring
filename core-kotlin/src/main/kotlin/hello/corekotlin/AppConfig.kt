package hello.corekotlin

import hello.corekotlin.discount.DiscountPolicy
import hello.corekotlin.discount.implement.RateDiscountPolicy
import hello.corekotlin.member.repository.MemberRepository
import hello.corekotlin.member.repository.MemoryMemberImpl
import hello.corekotlin.member.service.MemberService
import hello.corekotlin.member.service.MemberServiceImpl
import hello.corekotlin.order.implement.OrderServiceImpl
import hello.corekotlin.order.service.OrderService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfig {

    @Bean
    fun memberService(): MemberService = MemberServiceImpl(memberRepository())

    @Bean
    fun orderService(): OrderService = OrderServiceImpl(
        memberRepository(),
        discountPolicy()
    )

    @Bean
    fun memberRepository(): MemberRepository = MemoryMemberImpl()

    @Bean
    fun discountPolicy(): DiscountPolicy = RateDiscountPolicy()

}