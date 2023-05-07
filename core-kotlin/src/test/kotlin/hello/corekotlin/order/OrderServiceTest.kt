package hello.corekotlin.order

import hello.corekotlin.AppConfig
import hello.corekotlin.member.data.Grade
import hello.corekotlin.member.data.Member
import hello.corekotlin.member.service.MemberService
import hello.corekotlin.member.service.MemberServiceImpl
import hello.corekotlin.order.implement.OrderServiceImpl
import hello.corekotlin.order.service.OrderService
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test


class OrderServiceTest(

) {
    private lateinit var memberService: MemberService
    private lateinit var orderService: OrderService

    @BeforeEach
    fun beforeEach() {
        val appConfig = AppConfig()
        memberService = appConfig.memberService()
        orderService = appConfig.orderService()
    }

    @Test
    fun getDiscountPrice() {
        val memberId = 1L
        val member = Member(
            memberId,
            "memberA",
            Grade.VIP
        )

        memberService.join(member)
        val order = orderService.createOrder(memberId, "itemA", 10000)
        Assertions.assertThat(order.discountPrice).isEqualTo(1000)

    }
}