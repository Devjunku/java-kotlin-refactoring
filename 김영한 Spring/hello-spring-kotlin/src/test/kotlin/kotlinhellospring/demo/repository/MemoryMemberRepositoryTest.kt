package kotlinhellospring.demo.repository

import kotlinhellospring.demo.domain.Member
import org.assertj.core.api.Assertions.assertThat
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
        val member = Member().apply {
            name = "SpringBoot!!"
        }
        memoryMemberRepository.save(member)
        val result =  memoryMemberRepository.findByName(member.name!!)
        assertThat(member).isEqualTo(result)
    }

    @Test
    fun findByName() {

        val member1 = Member().apply {
            name = "spring1"
        }
        memoryMemberRepository.save(member1)

        val member2 = Member().apply {
            name = "spring2"
        }
        memoryMemberRepository.save(member2)

        assertThat(member1).isEqualTo(memoryMemberRepository.findByName("spring1"))
        assertThat(member2).isEqualTo(memoryMemberRepository.findByName("spring2"))
    }

    @Test
    fun findAll() {
        val member1 = Member().apply {
            name = "spring"
        }

        val member2 = Member().apply {
            name = "spring"
        }
        memoryMemberRepository.save(member1)
        memoryMemberRepository.save(member2)

        val result = memoryMemberRepository.findAll()

        assertThat(result.size).isEqualTo(2)


    }

}