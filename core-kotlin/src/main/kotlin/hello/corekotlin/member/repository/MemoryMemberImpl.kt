package hello.corekotlin.member.repository

import hello.corekotlin.member.data.Member
import java.util.concurrent.ConcurrentHashMap

class MemoryMemberImpl: MemberRepository {


    companion object {
        var store: ConcurrentHashMap<Long, Member> = ConcurrentHashMap()
    }

    override fun save(member: Member) {
        store.put(member.id, member)
    }

    override fun findById(memberId: Long): Member {
        return store.get(memberId)!!
    }

}