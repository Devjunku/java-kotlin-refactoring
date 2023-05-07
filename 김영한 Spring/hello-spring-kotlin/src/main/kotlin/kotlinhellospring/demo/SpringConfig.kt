package kotlinhellospring.demo

import kotlinhellospring.demo.repository.JdbcMemberRepository
import kotlinhellospring.demo.service.MemberService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@Suppress("SpringJavaInjectionPointsAutowiringInspection")
@Configuration
class SpringConfig @Autowired constructor(
    private val dataSource: DataSource
) {

    @Bean
    fun memberService(): MemberService = MemberService(memoryMemberRepository())

    @Bean
    fun memoryMemberRepository(): JdbcMemberRepository = JdbcMemberRepository(dataSource)

}