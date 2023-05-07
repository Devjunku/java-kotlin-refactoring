package hello.corekotlin.discount.implement

import hello.corekotlin.member.data.Grade
import hello.corekotlin.member.data.Member
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class RateDiscountPolicyTest {

    val rateDiscountPolicy = RateDiscountPolicy()

    @Test
    fun vip_o() {
        Member(
            1L,
            "memberA",
            Grade.VIP
        ).apply {
            Assertions
                .assertThat(rateDiscountPolicy.discount(this, 10000))
                .isEqualTo(1000)
        }
    }

    @Test
    fun vip_x() {
        Member(
            1L,
            "memberA",
            Grade.BASIC
        ).apply {
            Assertions
                .assertThat(rateDiscountPolicy.discount(this, 10000))
                .isEqualTo(0)
        }
    }
}