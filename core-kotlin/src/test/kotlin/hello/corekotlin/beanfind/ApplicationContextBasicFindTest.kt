package hello.corekotlin.beanfind

import hello.corekotlin.AppConfig
import hello.corekotlin.member.service.MemberService
import hello.corekotlin.member.service.MemberServiceImpl
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertThrows

private class ApplicationContextBasicFindTest {

    val ac = AnnotationConfigApplicationContext(AppConfig::class.java)

    @Test
    fun `빈 이름으로 조회`() {
        val memberService = ac.getBean("memberService", MemberService::class.java)
//        println("MemberService = " + memberService)
//        println("MemberService = " + memberService::class.java)

        /**
         * memberService가 MemberServiceImpl의 instance면 성공
         */
        assertThat(memberService).isInstanceOf(MemberServiceImpl::class.java)
    }

    @Test
    fun `빈 이름없이 타입으로 조회`() {
        val memberService = ac.getBean(MemberService::class.java)

        /**
         * memberService가 MemberServiceImpl의 instance면 성공
         */
        assertThat(memberService).isInstanceOf(MemberServiceImpl::class.java)
    }

    @Test
    fun `빈 이름없이 구체 타입으로 조회`() {
        val memberService = ac.getBean("memberService", MemberServiceImpl::class.java)

        /**
         * memberService가 MemberServiceImpl의 instance면 성공
         */
        assertThat(memberService).isInstanceOf(MemberServiceImpl::class.java)
    }

    @Test
    fun `이름으로 검색 X`() {
        // ac.getBean("xxxx", MemberServiceImpl::class.java)
        assertThrows()

    }


}