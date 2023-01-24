package kotlinhellospring.demo.repository

import kotlinhellospring.demo.domain.Member
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class MemoryMemberRepositoryTest @Autowired constructor(
    private val memoryMemberRepository: MemoryMemberRepository
) {

//    @Test
//    fun save() {
//        val member = Member()
//        memoryMemberRepository.save(member)
//        val result =  memoryMemberRepository.findById(member.id!!)
//        Assertions.assertEquals(member, result)
//    }

    @Test
    fun save() {
        val member = Member()
        member.name = "SpringBoot!!"
        memoryMemberRepository.save(member)
        val result =  memoryMemberRepository.findByName(member.name!!)
        Assertions.assertEquals(member, result)
    }

}