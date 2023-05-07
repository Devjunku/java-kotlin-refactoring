package hello.core.member.service;

import hello.core.member.data.Member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);

}
