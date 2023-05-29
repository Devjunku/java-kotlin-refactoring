package hello.corekotlin.beanfind

import hello.corekotlin.discount.DiscountPolicy
import hello.corekotlin.discount.implement.FixDiscountPolicy
import hello.corekotlin.discount.implement.RateDiscountPolicy
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.NoUniqueBeanDefinitionException
import org.springframework.beans.factory.getBean
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.Objects

private class ApplicationContextExtendsFindTest {

    val ac = AnnotationConfigApplicationContext(TestConfig::class.java)


    @Test
    fun `부모 타입으로 조회시, 자식이 2이상 조회되었을 때, 오류가 발생한다`() {
        assertThrows(NoUniqueBeanDefinitionException::class.java) {
            ac.getBean(DiscountPolicy::class.java)
        }
    }

    @Test
    fun `부모 타입으로 조회시, 자식이 2이상 조회되었을 때, 빈 이름을 지정하면 된다`() {
        val discountPolicy: DiscountPolicy = ac.getBean("rateDiscountPolicy", DiscountPolicy::class.java)
        assertThat(discountPolicy).isInstanceOf(DiscountPolicy::class.java)
    }


    @Test
    fun `부모 타입으로 전부 다 조회`() {
        val beansOfType = ac.getBeansOfType(DiscountPolicy::class.java)
        assertThat(beansOfType.size).isEqualTo(2)
        beansOfType.forEach { key, value ->
            println("key = $key, value = $value")
        }
    }

    @Test
    fun `오브젝트 타입 모두 꺼내기`() {
        ac.getBeansOfType(Object::class.java).forEach { key, value ->
            println("key = $key, value = $value")
        }
    }



    @Configuration
    class TestConfig {

        @Bean
        fun rateDiscountPolicy(): DiscountPolicy = RateDiscountPolicy()

        @Bean
        fun fixDiscountPolicy(): DiscountPolicy = FixDiscountPolicy()
    }




}