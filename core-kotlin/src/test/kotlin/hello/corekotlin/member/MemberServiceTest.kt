package hello.corekotlin.member

import hello.corekotlin.AppConfig
import hello.corekotlin.member.data.Grade
import hello.corekotlin.member.data.Member
import hello.corekotlin.member.service.MemberService
import hello.corekotlin.member.service.MemberServiceImpl
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test


class MemberServiceTest(
//    val memberService: MemberServiceImpl
) {
    private lateinit var memberService: MemberService;

    @BeforeEach
    fun beforeEach() {
        val appConfig = AppConfig()
        memberService = appConfig.memberService()
    }

    @Test
    fun join() {
        // Given
        val member = Member(
            id = 1L,
            name = "memberA",
            grade = Grade.VIP
        )

        // When
        memberService.join(member)
        val findMember = memberService.findMember(1L)

        // Then
        Assertions.assertThat(member).isEqualTo(findMember)
    }

}