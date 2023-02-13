package kotlinhellospring.demo

import kotlinhellospring.demo.repository.MemoryMemberRepository
import kotlinhellospring.demo.service.MemberService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
class SpringConfig {

    @Bean
    fun memberService(): MemberService = MemberService(memoryMemberRepository())

    @Bean
    fun memoryMemberRepository(): MemoryMemberRepository = MemoryMemberRepository()

}