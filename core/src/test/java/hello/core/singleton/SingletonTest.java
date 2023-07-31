package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.service.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();
        /**
         * 1. 조회: 호출 할 때마다 생성
         */

        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();
        MemberService memberService3 = appConfig.memberService();

        // 참조값이 다른지 확인
        System.out.println("memeberService1 = " + memberService1);
        System.out.println("memeberService2 = " + memberService2);
        System.out.println("memeberService3 = " + memberService3);

        // memberService1 != memberService2
        Assertions.assertThat(memberService1).isNotSameAs(memberService2);
    }


    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest() {
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonService2 = " + singletonService2);


        Assertions.assertThat(singletonService1).isSameAs(singletonService2);

    }

    /**
     * 스프링은 싱글톤 패턴의 단점을 모두 보완하고 싱글톤의 장점을 가져갈 수 있도록 도와준다.
     *
     */

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer() {
//        AppConfig appConfig = new AppConfig();
        /**
         * 1. 조회: 호출 할 때마다 생성
         */

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);
        MemberService memberService3 = ac.getBean("memberService", MemberService.class);

        // 참조값이 다른지 확인
        System.out.println("memeberService1 = " + memberService1);
        System.out.println("memeberService2 = " + memberService2);
        System.out.println("memeberService3 = " + memberService3);

        // memberService1 != memberService2
        Assertions.assertThat(memberService1).isSameAs(memberService2);
    }


}
