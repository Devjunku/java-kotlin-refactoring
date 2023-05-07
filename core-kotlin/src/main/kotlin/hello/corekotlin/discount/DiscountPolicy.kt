package hello.corekotlin.discount

import hello.corekotlin.member.data.Member

interface DiscountPolicy {

    fun discount(member: Member, price: Int): Int

}