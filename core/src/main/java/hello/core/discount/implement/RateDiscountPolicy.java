package hello.core.discount.implement;

import hello.core.discount.DiscountPolicy;
import hello.core.member.data.Grade;
import hello.core.member.data.Member;

public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10;


    @Override
    public int discount(Member member, int price) {

        int testPrice = price * discountPercent / 100 ;

        if (member.getGrade() == Grade.VIP) {
            return (price * discountPercent) / 100;
        } else {
            return 0;
        }
    }
}
