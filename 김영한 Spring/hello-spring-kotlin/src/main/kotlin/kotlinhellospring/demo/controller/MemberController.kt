package kotlinhellospring.demo.controller

import kotlinhellospring.demo.repository.MemoryMemberRepository
import kotlinhellospring.demo.service.MemberService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class MemberController @Autowired constructor(
    // 생성자 주입 방법
    private val memberService: MemberService
) {

    @GetMapping("/members/new")
    fun createForm(): String = "members/createMemberForm"


}
//class MemberController {
//    필드 주입 = (별로 안좋음 / 변화에 둔감)
//    @Autowired private val memberService = MemberService(memoryMemberRepository = MemoryMemberRepository())
//}