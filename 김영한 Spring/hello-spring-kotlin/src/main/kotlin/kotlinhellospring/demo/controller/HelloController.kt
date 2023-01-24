package kotlinhellospring.demo.controller

import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {
    @GetMapping("hello")
    fun hello(model: Model): String {
        model.addAttribute("data", "spring!!")
        return "hello"
    }

    @GetMapping("hello-mvc")
    fun helloMvc(
        @RequestParam(value = "name") name: String,
        model: Model
    ): String {
        model.addAttribute("name", name)
        return "hello-template"
    }

    @GetMapping("hello-string")
    @ResponseBody
    fun helloString(@RequestParam("name") name: String) = "hello $name"

    class Hello {
        var name:String? = null
    }

    @GetMapping("hello-api")
    @ResponseBody
    fun helloApi(name: String): Hello {
        val hello = Hello()
        hello.name = name
        return hello
    }
}