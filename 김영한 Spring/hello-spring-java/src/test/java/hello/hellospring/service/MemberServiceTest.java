package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    private final MemberRepository memoryMemberRepository = new MemoryMemberRepository();
    private final MemberService memberService;

    MemberServiceTest(MemberService memberService) {
        this.memberService = memberService;
    }

    /**
     * TEST가 동작하기 전에 만들어준다.
     */
//    @BeforeEach
//    public void beforeEach() {
//        memoryMemberRepository = new MemoryMemberRepository();
//        memberService = new MemberService(memoryMemberRepository);
//    }

    @AfterEach
    void afterEach() {
//        memoryMemberRepository.clearStore();
    }

    /**
     * 회원가입이 잘 되는지?
     * member객체를 만들고 회원가입 시키고 이게 내가 만든 회원과 동일한지 확인
     * 테스트 코드는 과감하게 한글로 적어도 된다.
     */
    @Test
    void 회원가입() {
        /*
        서비스 클래스를 테스트 코드로 작성할 떄는 아래와 같이 형식을 지치는 것이 좋다.
        1. Given
        2. When
        3. Then

        테스트는 정상 flow도 중요하지만, 예외 flow가 제일 중요하다.
        따라서 validate가 터지는지 봐야한다.
         */

        // TODO: Given: 테스트 데이터 할당
        Member member = new Member();
        member.setName("Test1");

        // TODO: When 테스트를 검증을 위한 함수 작동
        Long testId  = memberService.join(member);

        // TODO: Then 테스트 검증 (Repo)에 있는게 맞는지 확인하고 싶은 것!
        Member findMember = memberService.findOne(testId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외_검즘() {
        // TODO Given
        Member testMember1 = new Member();
        testMember1.setName("ValidateTest");

        Member testMember2 = new Member();
        testMember2.setName("ValidateTest");

        // TODO When
        // TODO Then
        memberService.join(testMember1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(testMember2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

        /**
         *  아래 코드로 검증해도 되지만, 이건 너무 길어서 별로 좋은 코드는 아니다.
         */
//        try {
//            memberService.join(testMember2);
//            fail();
//        } catch (IllegalStateException e) {
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}