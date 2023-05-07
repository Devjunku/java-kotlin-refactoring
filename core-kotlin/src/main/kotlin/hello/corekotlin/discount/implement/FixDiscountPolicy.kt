package hello.corekotlin.discount.implement

import hello.corekotlin.discount.DiscountPolicy
import hello.corekotlin.member.data.Grade
import hello.corekotlin.member.data.Member

class FixDiscountPolicy: DiscountPolicy {

    private val discountFixAmount = 1000

    override fun discount(member: Member, price: Int): Int {
        return member.run {
            if (this.grade == Grade.VIP) {
                discountFixAmount
            } else {
                0
            }
        }
    }
}