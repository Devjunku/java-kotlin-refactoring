package hello.corekotlin.singleton

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean

internal class StatefulServiceTest {

    /**
     * 공유되는 변수를 최대한 자제 할 것
     * 그냥 코드를 짤 때 습관적으로 전역변수 설정은 자제 하고
     * local variable로 처리하는 습관을 지니는 것이 좋다
     */

    @Test
    fun statefulServiceSingleTon() {
        val ac = AnnotationConfigApplicationContext(TestConfig::class.java)

        val statefulService1 = ac.getBean(StatefulService::class.java)
        val statefulService2 = ac.getBean(StatefulService::class.java)

        val userAPrice = statefulService1.order("userA", 10000)
        val userBPrice = statefulService2.order("userB", 20000)

        // val price = statefulService1.price
        println("userAPrice = $userAPrice")
        println("userBPrice = $userBPrice")

        Assertions.assertThat(userAPrice).isEqualTo(10000)

    }

    class TestConfig {

        @Bean
        fun statefulService(): StatefulService {
            return StatefulService()
        }

    }

}