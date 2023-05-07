package kotlinhellospring.demo.repository

import kotlinhellospring.demo.domain.Member
import org.springframework.stereotype.Repository
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

/**
 * bean으로 등록하여 관리하려면
 * Component 또는 Repository Annotation을 사용하여 등록하면 된다.
 * 테스트 코드가.. 안ㄷ...
 */
// @Repository
class MemoryMemberRepository : MemberRepository {

    companion object {
        /**
         * kotlin에서 hashMap을 쓰고 싶으면 collection에서 찾아서 써야 compile error가 안남.
         * Map을 쓰면 안 됨(연동이 안 됨).
         */
        var store: HashMap<Long, Member> = hashMapOf()
        var sequence: Long = 0L
    }


    override fun save(member: Member): Member {
        member.id = ++sequence
        store[member.id!!] = member
        return member
    }

    /**
     * 이건 다시 해봐야겠다.
     * kotlin에서 Optional을 다루는 방법은 따로 있을 것이다.
     * kotlin에서는 Optiona을 따로 쓰지 않아도 된다.
     */
    override fun findById(id: Long): Member? {
        return store[id]
    }

    override fun findByName(name: String?): Member? = store.values.find { member -> member.name == name }

    override fun findAll(): List<Member> {
        return ArrayList(store.values)
    }

    fun clearStore() {
        store.clear()
    }


}