package hello.corekotlin.singleton

import hello.corekotlin.AppConfig
import hello.corekotlin.member.service.MemberService
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.getBean
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class SingletonTest {

    @Test
    fun `스프링 없는 순수한 DI 컨테이너`() {

        val appConfig = AppConfig()

        /**
         * 1. 조회: 호출할 마다 생성
         */

        val memberService1 = appConfig.memberService()
        val memberService2 = appConfig.memberService()
        val memberService3 = appConfig.memberService()

        // 참조값이 다른지 확인
        println("memberService1 = $memberService1")
        println("memberService2 = $memberService2")
        println("memberService3 = $memberService3")

        // memberService1 != memberService2
        Assertions.assertThat(memberService1).isNotSameAs(memberService2)
    }

    @Test
    fun `싱글톤 패턴을 적용한 객체 사용`() {

        // 코틀린의 경우 Singleton pattern을 접근할 떄 r

        val singletonService1 = SingletonService
        val singletonService2 = SingletonService

        println("singletonService1 = ${SingletonService.printMsg(singletonService1.toString())}")
        println("singletonService2 = ${SingletonService.printMsg(singletonService2.toString())}")

        Assertions.assertThat(singletonService1).isSameAs(singletonService2)
    }

    @Test
    fun `스프링 컨테이너와 싱글톤`() {

        val ac = AnnotationConfigApplicationContext(AppConfig::class.java)

        /**
         * 1. 조회: 호출할 마다 생성
         */

        val memberService1 = ac.getBean("memberService", MemberService::class.java)
        val memberService2 = ac.getBean("memberService", MemberService::class.java)
        val memberService3 = ac.getBean("memberService", MemberService::class.java)

        // 참조값이 다른지 확인
        println("memberService1 = $memberService1")
        println("memberService2 = $memberService2")
        println("memberService3 = $memberService3")

        // memberService1 != memberService2
        Assertions.assertThat(memberService1).isSameAs(memberService2)
    }

}