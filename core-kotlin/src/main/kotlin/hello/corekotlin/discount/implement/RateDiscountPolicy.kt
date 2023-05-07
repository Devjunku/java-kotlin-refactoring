package hello.corekotlin.discount.implement

import hello.corekotlin.discount.DiscountPolicy
import hello.corekotlin.member.data.Grade
import hello.corekotlin.member.data.Member

class RateDiscountPolicy: DiscountPolicy {

    private val dicountRate = 10;

    override fun discount(member: Member, price: Int): Int {
        return member.run {
            if (member.grade == Grade.VIP) {
                price * dicountRate / 100
            } else {
                0
            }
        }
    }
}