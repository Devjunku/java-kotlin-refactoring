package hello.corekotlin


import hello.corekotlin.member.data.Grade
import hello.corekotlin.member.data.Member
import hello.corekotlin.member.service.MemberServiceImpl
import hello.corekotlin.order.implement.OrderServiceImpl


fun main() {

    val appConfig = AppConfig()

    val memberService = appConfig.memberService()
    val orderService = appConfig.orderService()

    val memberId = 1L
    val member = Member(
        memberId,
        "memberA",
        Grade.BASIC

    )


    memberService.join(member)
    val order = orderService.createOrder(memberId, "itemA", 9999)

    println("order = " + order.toString())
    println("discountedPrice = " + order.calculatePrice().toString())
}