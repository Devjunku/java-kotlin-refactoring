package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.text.html.Option;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();

    @Test
    public void save() {
        Member member = new Member();
        member.setName("SpringBoot!!");
        memoryMemberRepository.save(member);

        Member result = memoryMemberRepository.findById(member.getId()).get();
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

        Member member1  = new Member();
        member1.setName("spring1");
        memoryMemberRepository.save(member1);

        // shift f6 누르면 한번에 다 바꿈
        Member member2  = new Member();
        member2.setName("spring2");
        memoryMemberRepository.save(member2);

        Member result1 = memoryMemberRepository.findByName("spring1").get();
        Member result2 = memoryMemberRepository.findByName("spring2").get();

        assertThat(result1).isEqualTo(member1);
        assertThat(result2).isEqualTo(member2);
    }

}
