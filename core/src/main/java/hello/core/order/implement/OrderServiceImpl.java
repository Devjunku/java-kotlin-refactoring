package hello.core.order.implement;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.implement.FixDiscountPolicy;
import hello.core.member.data.Member;
import hello.core.member.repository.MemberRepository;
import hello.core.order.data.Order;
import hello.core.order.service.OrderService;

public class OrderServiceImpl implements OrderService {

    private MemberRepository memberRepository;
    private DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 테스트용
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

}
