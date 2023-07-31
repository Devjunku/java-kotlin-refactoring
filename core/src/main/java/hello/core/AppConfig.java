package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.implement.FixDiscountPolicy;
import hello.core.discount.implement.RateDiscountPolicy;
import hello.core.member.repository.MemberRepository;
import hello.core.member.repository.MemberRepositoryImpl;
import hello.core.member.service.MemberService;
import hello.core.member.service.MemberServiceImpl;
import hello.core.order.implement.OrderServiceImpl;
import hello.core.order.service.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sound.midi.Soundbank;

@Configuration
public class AppConfig {

    /**
     * 아래와 같이 Refactoring 하는게 좋은 이유
     * 1. Method 이름으로 역할이 모두 드러난다.
     * 2. Repo를 지금처럼 Memory가 아니라, DB를 사용한다고 하면, 해당 클래스 명칭만 바꾸면 된다.
     */

    // @Bean은 memberService를 호출하면서 new MemberRepositoryImpl()를 한 번 호출 해줌
    // @Bean은 OrderService를 호출하면서 new MemberRepositoryImpl()를 한 번 호출 해줌
    // 결과적으로 MemberRepositoryImpl를 총 2번 호출하게 됨.

    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy()
        );
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemberRepositoryImpl();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        System.out.println("call AppConfig.discountPolicy");
        return new RateDiscountPolicy();
    }
}
