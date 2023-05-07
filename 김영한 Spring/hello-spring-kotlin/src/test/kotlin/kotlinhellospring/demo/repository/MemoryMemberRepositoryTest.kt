package kotlinhellospring.demo.repository

import kotlinhellospring.demo.domain.Member
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class MemoryMemberRepositoryTest @Autowired constructor(
    private val jdbcMemberRepository: JdbcMemberRepository
) {

//    @Test
//    fun save() {
//        val member = Member()
//        memoryMemberRepository.save(member)
//        val result =  memoryMemberRepository.findById(member.id!!)
//        Assertions.assertEquals(member, result)
//    }

//    @AfterEach
//    fun afterEach() = jdbcMemberRepository.clear()

    @Test
    fun save() {
        val member = Member(name = "SpringBoot!!")
        jdbcMemberRepository.save(member)
        val result =  jdbcMemberRepository.findByName(member.name!!)
        assertThat(member).isEqualTo(result)
    }

    @Test
    fun findByName() {

        val member1 = Member(name = "spring1")
        jdbcMemberRepository.save(member1)

        val member2 = Member(name = "spring2")
        jdbcMemberRepository.save(member2)

        assertThat(member1).isEqualTo(jdbcMemberRepository.findByName("spring1"))
        assertThat(member2).isEqualTo(jdbcMemberRepository.findByName("spring2"))
    }

    @Test
    fun findAll() {
        val member1 = Member(name = "spring3")
        val member2 = Member(name = "spring4")

        jdbcMemberRepository.save(member1)
        jdbcMemberRepository.save(member2)

        val result = jdbcMemberRepository.findAll()

        assertThat(result.size).isEqualTo(2)


    }

}