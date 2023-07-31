package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    /**
     * 공유되는 변수를 최대한 자제 할 것
     * 그냥 코드를 짤 때 습관적으로 전역변수 설정은 자제 하고
     * local variable로 처리하는 습관을 지니는 것이 좋다
     */

    @Test
    void statefulServiceSingleTon() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        // ThreadA: userA가 10000원을 추문
        int userAPrice = statefulService1.order("userA", 10000);

        // ThreadB: userB가 20000원을 주문
        int userBPrice = statefulService2.order("userB", 20000);

        // ThreadA: 사용자A의 주문가격을 조회
        // int price = statefulService1.getPrice();
        System.out.println("userAPrice = " + userAPrice);
        System.out.println("userBPrice = " + userBPrice);
        // ThreadB: 사용자B의 주문가격을 조회

        Assertions.assertThat(userAPrice).isEqualTo(10000);
    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }

    }


}