package hello.corekotlin.beanfind

import hello.corekotlin.member.repository.MemberRepository
import hello.corekotlin.member.repository.MemoryMemberImpl
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.NoUniqueBeanDefinitionException
import org.springframework.beans.factory.getBeansOfType
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

private class ApplicationContextSameBeanFindTest {

    val ac = AnnotationConfigApplicationContext(SameBeanConfig::class.java)

    @Test
    fun `타입으로 조회시 같은 타입이 둘 이상 있으면, 중복 오류가 발생한다`() {
//        val bean = ac.getBean(MemberRepository::class.java)
        assertThrows(NoUniqueBeanDefinitionException::class.java) {
            ac.getBean(MemberRepository::class.java)
        }
    }

    @Test
    fun `타입으로 조회시 같은 타입이 둘 이상 있으면, 이름을 지정하면 된다`() {

        val memberRepository = ac.getBean("memberRepository1", MemberRepository::class.java)
        assertThat(memberRepository).isInstanceOf(MemberRepository::class.java)

    }

    @Test
    fun `특정 타입을 모두 조회`() {
        val beansOfType: Map<String, MemberRepository> = ac.getBeansOfType(MemberRepository::class.java)
        for (key in beansOfType.keys) {
            println("key = " + key + "value = " + beansOfType[key])
        }
        println("beansOfType = " + beansOfType);
        assertThat(beansOfType.size).isEqualTo(2)
    }


    @Configuration
    class SameBeanConfig {

        @Bean
        fun memberRepository1(): MemberRepository = MemoryMemberImpl()

        @Bean
        fun memberRepository2(): MemberRepository = MemoryMemberImpl()

    }


}