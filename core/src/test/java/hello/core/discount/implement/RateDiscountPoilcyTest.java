package hello.core.discount.implement;

import hello.core.member.data.Grade;
import hello.core.member.data.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RateDiscountPoilcyTest {

    RateDiscountPolicy rateDiscountPoilcy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void vip_o() {
        //given
        Member member = new Member(
                1L,
                "memberA",
                Grade.VIP
        );
        // when
        int discount = rateDiscountPoilcy.discount(member, 10000);

        // then
        Assertions.assertThat(discount).isEqualTo(1000);
    }

    /**
     * 테스트는 성공도 좋지만, 실패 테스트도 꼭 만들어야 한다.
     * 예외를 어떻게 던져줄 것인지 알아야 하기 때문이다.
     */


    @Test
    @DisplayName("VIP가 아니면, 할인이 적용되면 안 된다.")
    void vip_x() {
        Member member = new Member(
                1L,
                "memberA",
                Grade.BASIC
        );
        int discount = rateDiscountPoilcy.discount(member, 10000);

        Assertions.assertThat(discount).isEqualTo(0);
    }
}