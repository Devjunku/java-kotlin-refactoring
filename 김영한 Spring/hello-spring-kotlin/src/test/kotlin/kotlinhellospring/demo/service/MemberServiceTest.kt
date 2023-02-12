package kotlinhellospring.demo.service

import kotlinhellospring.demo.domain.Member
import kotlinhellospring.demo.repository.MemoryMemberRepository
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest
internal class MemberServiceTest @Autowired constructor(
    private val memoryMemberRepository: MemoryMemberRepository,
    private val memberService: MemberService,
) {

    /**
     * kotlin의 경우 Autowired를 통해 주입받는 로직이 필요가 없다.
     */

    @AfterEach
    fun afterEach() {
        memoryMemberRepository.clearStore()
        println(memoryMemberRepository.toString())
        println(memberService.memoryMemberRepository.toString())
    }

    @Test fun `회원가입`() {

        // TODO given
        val member = Member(name = "Test1")

        // TODO When / fail()은 assertTions class에 있음
        val repoMember = memberService.join(member)?.let {
            memberService.findOne(it)
        } ?: run{ fail() }

        // TODO Then
        assertThat(repoMember.name).isEqualTo(member.name)
    }

    @Test fun `중복 회원 예외 검즘`() {
        // TODO given
        val testMember1 = Member(name = "validateTest")
        val testMember2 = Member(name = "validateTest")

        // TODO When
        memberService.join(testMember1)
        val `exception` = assertThrows(IllegalStateException::class.java) { memberService.join(testMember2) }
        assertThat(`exception`.message).isEqualTo("이미 존재하는 회원입니다.")

        // TODO Then
        /**
         * 아래 코드로 검증해도 되지만, 이건 너무 길어서 별로 좋은 코드는 아니다.
         */
//        try {
//            memberService.join(testMember2);
//            fail();
//        } catch (e: IllegalStateException) {
//            assertThat(e.message).isEqualTo("이미 존재하는 회원입니다.");
//        }
    }

    @Test fun findMembers() {
    }

    @Test
    fun findOne() {
    }
}