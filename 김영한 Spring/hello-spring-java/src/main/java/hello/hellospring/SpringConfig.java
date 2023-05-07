package hello.hellospring;


import hello.hellospring.repository.JdbcMemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.JdbcMemberService;
import hello.hellospring.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * 직접 Spring Bean에 등록하는 방법
 *
 * @Configuration
 * @Bean 사용
 */

@Configuration
@RequiredArgsConstructor
public class SpringConfig {

    private final DataSource dataSource;
//

    /*
    일반적으로 우리가 작성하는 Controller, Service, Repository는 ComponentScan을 사용한다.
    하지만, 그 이외에 우리가 Bean에 등록하여 Spring이 직접 관리해야 하는 파일의 경우
    아래와 같은 방식으로 직접 Bean에 등록한다.

    여기서 기존에 운영되던 코드를 하나도 손대지 않고 바꿔치기 할 수 있는 방법이 있다.
    그게 바로 이 방법이다.
     */

    //    @Bean
//    public MemberService memberService() {
//        return new MemberService(memoryMemberRepository());
//    }
//
//    @Bean
//    public JdbcMemberService jdbcMemberService() {
//        return new JdbcMemberService(jdbcMemberRepository());
//    }
//
//    @Bean
//    public MemoryMemberRepository memoryMemberRepository() {
//        return new MemoryMemberRepository();
//    }
//
    @Bean
    public JdbcMemberRepository jdbcMemberRepository() {
        return new JdbcMemberRepository(dataSource);
    }


}
