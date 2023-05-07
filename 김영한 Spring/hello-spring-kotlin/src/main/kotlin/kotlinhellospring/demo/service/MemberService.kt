package kotlinhellospring.demo.service

import kotlinhellospring.demo.domain.Member
import kotlinhellospring.demo.repository.JdbcMemberRepository
import org.springframework.stereotype.Service

// @Service
class MemberService(
    val jdbcMemberRepository: JdbcMemberRepository,
) {

    fun join(member: Member): Long? {
        validateDuplicateMember(member)
        jdbcMemberRepository.save(member)
        return member.id
    }

    private fun validateDuplicateMember(member: Member) {
        jdbcMemberRepository.findByName(member.name)?.let {
            throw IllegalStateException("이미 존재하는 회원입니다.")
        }
    }


    /**
     * 전체 회원 조회
     */
    fun findMembers(): List<Member> = jdbcMemberRepository.findAll()

    /**
     * 특정 회원 조회
     */
    fun findOne(id: Long): Member? = jdbcMemberRepository.findById(id)


}