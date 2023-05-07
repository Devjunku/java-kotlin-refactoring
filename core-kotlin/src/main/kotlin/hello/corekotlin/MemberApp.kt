package hello.corekotlin

import hello.corekotlin.member.data.Grade
import hello.corekotlin.member.data.Member

fun main() {

    val appConfig = AppConfig();
    val memberService = appConfig.memberService()

    val member = Member(
        id = 1L,
        name = "memberA",
        grade = Grade.VIP
    )
    memberService.join(member)
    val findMember = memberService.findMember(1L)
    println("New Member = " + member.grade)
    println("Find Member = " + findMember.grade)
}