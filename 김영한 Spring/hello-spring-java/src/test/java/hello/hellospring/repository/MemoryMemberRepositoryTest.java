package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();

    @Test
    public void save() {
        Member member = new Member();
        member.setName("SpringBoot!!");
        memoryMemberRepository.save(member);

        Member result = memoryMemberRepository.findById(member.getId()).get();
//        Assertions.assertEquals(member, result);
        // expected, actual 순으로
        assertThat(member).isEqualTo(result);

    }

}
