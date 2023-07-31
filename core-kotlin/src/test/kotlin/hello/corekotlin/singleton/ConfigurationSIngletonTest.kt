package hello.corekotlin.singleton

import hello.corekotlin.AppConfig
import hello.corekotlin.member.repository.MemberRepository
import hello.corekotlin.member.repository.MemoryMemberImpl
import hello.corekotlin.member.service.MemberServiceImpl
import hello.corekotlin.order.implement.OrderServiceImpl
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class ConfigurationSIngletonTest {

    val ac = AnnotationConfigApplicationContext(AppConfig::class.java)

    @Test
    fun configurationTest() {
        val memberService = ac.getBean("memberService", MemberServiceImpl::class.java)
        val orderService = ac.getBean("orderService", OrderServiceImpl::class.java)

        val memberRepository1 = memberService.getMemberRepository()
        val memberRepository2 = orderService.getMemberRepository()
        val memberRepository3 = ac.getBean("memberRepository", MemberRepository::class.java)

        println("memberService MemberRepository = ${memberRepository1}")
        println("orderService MemberRepository = ${memberRepository2}")
        println("orderService MemberRepository = ${memberRepository3}")

        Assertions.assertThat(memberRepository1).isSameAs(memberRepository2)
        Assertions.assertThat(memberRepository3).isSameAs(memberRepository1)

    }


}