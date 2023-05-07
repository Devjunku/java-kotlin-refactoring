package hello.core.member.repository;

import hello.core.member.data.Member;

import java.util.concurrent.ConcurrentHashMap;


public class MemberRepositoryImpl implements MemberRepository {
    // static을 붙이지 않으면, new MemoryMemberRepository을 진행했을 때, 다른 주소의 class를 들고옴.
    private static ConcurrentHashMap<Long, Member> store = new ConcurrentHashMap<>();
//     private static Map<Long, Member> store = new HashMap<>();
    // 동시성 문제로 인한 컨커런트 해쉬맵를 사용하는게 일반적임


    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
