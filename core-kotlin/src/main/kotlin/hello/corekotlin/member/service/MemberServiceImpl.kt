package hello.corekotlin.member.service

import hello.corekotlin.member.data.Member
import hello.corekotlin.member.repository.MemberRepository

class MemberServiceImpl(
    private val memberRepository: MemberRepository
): MemberService {

    override fun join(member: Member) {
        memberRepository.save(member)
    }

    override fun findMember(memberId: Long): Member {
        return memberRepository.findById(memberId)
    }

    fun getMemberRepository(): MemberRepository {
        return memberRepository;
    }
}