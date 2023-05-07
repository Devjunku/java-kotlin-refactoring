package hello.corekotlin.member.service

import hello.corekotlin.member.data.Member

interface MemberService {

    fun join(member: Member)

    fun findMember(memberId: Long): Member

}