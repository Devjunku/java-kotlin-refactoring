package hello.corekotlin.xml

import hello.corekotlin.member.service.MemberService
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.context.support.GenericXmlApplicationContext

internal class XmlAppContext {
    @Test
    fun xmlAppContext() {
        val memberService = GenericXmlApplicationContext(
            "appContext.xml"
        ).getBean("memberService", MemberService::class.java)
        assertThat(memberService).isInstanceOf(MemberService::class.java)
    }
}