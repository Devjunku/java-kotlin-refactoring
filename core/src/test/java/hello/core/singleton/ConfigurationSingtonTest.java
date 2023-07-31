package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.repository.MemberRepository;
import hello.core.member.service.MemberService;
import hello.core.member.service.MemberServiceImpl;
import hello.core.order.implement.OrderServiceImpl;
import hello.core.order.service.OrderService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingtonTest {

    @Test
    void configurationTest() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();
        MemberRepository memberRepository3 = ac.getBean("memberRepository", MemberRepository.class);

        System.out.println("memberService MemberRepository = " + memberRepository1);
        System.out.println("orderservice MemberRepository = " + memberRepository2);
        System.out.println("memberRepository MemberRepository = " + memberRepository3);

        Assertions.assertThat(memberRepository1).isSameAs(memberRepository2);
        Assertions.assertThat(memberRepository1).isSameAs(memberRepository3);
    }

}
