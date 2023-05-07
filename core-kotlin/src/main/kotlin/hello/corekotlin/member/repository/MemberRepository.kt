package hello.corekotlin.member.repository

import hello.corekotlin.member.data.Member

interface MemberRepository {

    fun save(member: Member)

    fun findById(MemberId: Long): Member

}