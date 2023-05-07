package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class JdbcMemberRepositoryTest {

    /**
     * TEST는 메소드 각각이 서로에게 의존관계가 없어야 한다.
     */
    @Autowired
    JdbcMemberRepository repository;



    @AfterEach
    public void afterEach() {
//        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("SpringBoot!!");
        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        // expected, actual 순으로
//        Assertions.assertEquals(member, result); 이것보다 떠 빠르게 검증하고 싶으면 아래 assertThat을 하면 된다.
        // 아래는 테스트 통과 못하면 다음 단계 못가게 막아버림
        assertThat(member).isEqualTo(result);

    }

    @Test
    public void findByName() {
        /**
         * 다른 이름을 갖는 ID 2개를 만들어보자
         */

        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        // shift f6 누르면 한번에 다 바꿈
        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result1 = repository.findByName("spring1").get();
        Member result2 = repository.findByName("spring2").get();

        assertThat(result1).isEqualTo(member1);
        assertThat(result2).isEqualTo(member2);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring3");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring4");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);

    }

}
