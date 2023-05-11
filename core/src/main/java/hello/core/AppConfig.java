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

public class AppConfig {

    /**
     * 아래와 같이 Refactoring 하는게 좋은 이유
     * 1. Method 이름으로 역할이 모두 드러난다.
     * 2. Repo를 지금처럼 Memory가 아니라, DB를 사용한다고 하면, 해당 클래스 명칭만 바꾸면 된다.
     */

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(
                memberRepository(),
                disiscountPolicy()
        );
    }

    private MemberRepository memberRepository() {
        return new MemberRepositoryImpl();
    }

    private DiscountPolicy disiscountPolicy() {
        return new RateDiscountPolicy();
    }
}
