package kotlinhellospring.demo.controller

import kotlinhellospring.demo.repository.MemoryMemberRepository
import kotlinhellospring.demo.service.MemberService
import kotlinhellospring.demo.domain.Member
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

@Controller
class MemberController @Autowired constructor(
    // 생성자 주입 방법
    private val memberService: MemberService
) {

    @GetMapping("/members/new")
    fun createForm(): String = "members/createMemberForm"


    @PostMapping("/members/new")
    fun create(form: MemberForm): String = Member()
        .apply { name = form.name }
        .let {
            memberService.join(it)
            "redirect:/"
        }


    @GetMapping("/members")
    fun list(model: Model): String = memberService.findMembers()
            .let {
                model.addAttribute("members", it)
                "members/memberList"
            }

}
//class MemberController {
//    필드 주입 = (별로 안좋음 / 변화에 둔감)
//    @Autowired private val memberService = MemberService(memoryMemberRepository = MemoryMemberRepository())
//}