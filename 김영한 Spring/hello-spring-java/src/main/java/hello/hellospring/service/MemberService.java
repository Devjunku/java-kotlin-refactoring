package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    /**
     * TEST CODE까지 같은 Repo를 쓰도록 만들고 싶으면 아래와 같이 외부에서 직접 넣어주도록 만들어주는 것이 좋다.
     */
    private final MemoryMemberRepository memoryMemberRepository ;

    // 내부에서 선언하지 않고 외부에서 주입하는 방식 DI Dependency Injection
    public MemberService(MemoryMemberRepository memoryMemberRepository) {
        this.memoryMemberRepository = memoryMemberRepository;
    }


    /**
     *  회원가입
     *  Optional로 감싸면 Optional 안에 맴버 객체가 있는 것임.
     */
    public Long join(Member member) {

        validateDuplicateMember(member); // 중복회원 검증

        memoryMemberRepository.save(member);
        return member.getId();
    }

    /**
     * 직접 바로 꺼낼 수 있으나, 직접 꺼내는 걸 권장하지는 않는다.
     * 또한 바로 Optional<Member>를 반환하는게 이쁘진 않다.
     */
    private void validateDuplicateMember(Member member) {
        memoryMemberRepository.findByName(member.getName())
            .ifPresent(m -> { throw new IllegalStateException("이미 존재하는 회원입니다."); });
    }

    /**
     * 전체 회원 기능 조회
     */
    public List<Member> findMembers() {
        return memoryMemberRepository.findAll();
    }

    /**
     * 특정 회원 조회
     */

    public Optional<Member> findOne(Long id) {
        return memoryMemberRepository.findById(id);
    }


}
