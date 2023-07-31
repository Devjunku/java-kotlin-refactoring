package hello.corekotlin.member.repository

import hello.corekotlin.member.data.Member
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


interface MemberRepository {

    fun save(member: Member)

    fun findById(MemberId: Long): Member

}