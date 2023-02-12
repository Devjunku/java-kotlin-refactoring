package kotlinhellospring.demo.service

import kotlinhellospring.demo.domain.Member
import kotlinhellospring.demo.repository.MemoryMemberRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MemberService(
    val memoryMemberRepository: MemoryMemberRepository,
) {

    fun join(member: Member): Long? {
        validateDuplicateMember(member)
        memoryMemberRepository.save(member)
        return member.id
    }

    private fun validateDuplicateMember(member: Member) {
        memoryMemberRepository.findByName(member.name)?.let {
            throw IllegalStateException("이미 존재하는 회원입니다.")
        }
    }


    /**
     * 전체 회원 조회
     */
    fun findMembers(): List<Member> = memoryMemberRepository.findAll()

    /**
     * 특정 회원 조회
     */
    fun findOne(id: Long): Member? = memoryMemberRepository.findById(id)


}