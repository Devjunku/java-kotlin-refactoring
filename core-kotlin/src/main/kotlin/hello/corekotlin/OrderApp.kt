package hello.corekotlin


import hello.corekotlin.member.data.Grade
import hello.corekotlin.member.data.Member
import hello.corekotlin.member.service.MemberService
import hello.corekotlin.member.service.MemberServiceImpl
import hello.corekotlin.order.implement.OrderServiceImpl
import hello.corekotlin.order.service.OrderService
import org.springframework.context.annotation.AnnotationConfigApplicationContext


fun main() {

//    val appConfig = AppConfig()
//
//    val memberService = appConfig.memberService()
//    val orderService = appConfig.orderService()

    val applicationContext = AnnotationConfigApplicationContext(AppConfig::class.java)
    val memberService = applicationContext.getBean("memberService", MemberService::class.java)
    val orderService = applicationContext.getBean("orderService", OrderService::class.java)

    val memberId = 1L
    val member = Member(
        memberId,
        "memberA",
        Grade.VIP

    )


    memberService.join(member)
    val order = orderService.createOrder(memberId, "itemA", 20000)

    println("order = " + order.toString())
    println("discountedPrice = " + order.calculatePrice().toString())
}