package hello.corekotlin.beanfind

import hello.corekotlin.AppConfig
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.config.BeanDefinition
import org.springframework.beans.factory.config.BeanDefinition.ROLE_APPLICATION
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean


class ApplicationContextInfoTest {

    val ac = AnnotationConfigApplicationContext(AppConfig::class.java)

    @Test
    @DisplayName("모든 빈 찾기")
    fun findAllBean() {
//        val beanDefinitionNames = ac.beanDefinitionNames;
//        for (beanDefinitionName in beanDefinitionNames) {
//            val bean = ac.getBean(beanDefinitionName)
//            println("bean = " + beanDefinitionName + "object = " + bean)
//        }

        ac.beanDefinitionNames.forEach { beanDefinitionName ->
            ac.getBean(beanDefinitionName).let { bean ->
                    println("bean = " + beanDefinitionName + "object = " + bean)
                }
        }
    }

    @Test
    @DisplayName("어플리케이션 빈 찾기")
    fun findApplicationBean() {
//        val beanDefinitionNames = ac.beanDefinitionNames;
//        for (beanDefinitionName in beanDefinitionNames) {
//            val bean = ac.getBean(beanDefinitionName)
//            println("bean = " + beanDefinitionName + "object = " + bean)
//        }

        ac.beanDefinitionNames.forEach { beanDefinitionName ->
            ac.getBeanDefinition(beanDefinitionName). let {
                if (it.getRole() == ROLE_APPLICATION) {
                    ac.getBean(beanDefinitionName).let { bean ->
                        println("bean = " + beanDefinitionName + "object = " + bean)
                    }
                }
            }

        }
    }



}