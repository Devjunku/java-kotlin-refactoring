package hello.core.discount.implement;

import hello.core.discount.DiscountPolicy;
import hello.core.member.data.Grade;
import hello.core.member.data.Member;

public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        // enum 타입은 == 쓰는게 맞음
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
