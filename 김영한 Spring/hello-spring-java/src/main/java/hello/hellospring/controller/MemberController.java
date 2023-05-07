package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * Spring Bean을 등록하는 방법
 * 1. 컴포넌트와 자동 의존관계 설정 (@Controller, @Service, @Repository)
 * 2. 자바 코드로 직접 스프링 빈에 등록
 */


//@Controller
public class MemberController {

    private final MemberService memberService;

    /**
     * @Autowired는 Spring Container에 등록된 객체(Bean)만 가져올 수 있음.
     * 따라서 가져오려는 MemberService를 Container에 등록해야 함.
     */
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    /*
    Setter 주입 방법 / 단점: public하게 노출됨.
    private MemberService memberService;
    @Autowired
    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }

    아무 개발자나 memberService.setMemberService(); 를 호출할 수 있음.
    */

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    /*
    데이터를 넣어서 보내줄 때 POST
    데이터를 조회할 때 GET
     */
    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }



}
