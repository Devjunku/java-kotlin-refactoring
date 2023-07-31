package hello.corekotlin.beandefinition

import hello.corekotlin.AppConfig
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.config.BeanDefinition
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class BeanDefinitionTest {


    var ac = AnnotationConfigApplicationContext(AppConfig::class.java)


    @Test
    fun `빈 설정 메타 정보 확인`() {
        val beanDefinitionNames  = ac.getBeanDefinitionNames()
        for (beanDefinitionName in beanDefinitionNames) {
            val beanDefinition = ac.getBeanDefinition(beanDefinitionName)

            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                println(
                    "beanDefinitionName = $beanDefinitionName \n beanDefinition = $beanDefinition "
                )
            }
        }

    }





}