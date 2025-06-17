package com.example.demo.controller;

import com.example.demo.domain.Member;
import com.example.demo.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {


    // this sample
    // work controller ....skdjfksjdfkjsdlfkjsldfjs
    private final MemberService memberService;

    public HomeController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/form")
    public String memberAddForm() {
        return "memberAddForm";
    }


    // developer A : work this file
    // add this commend



    @GetMapping("/form2")
    public String memberAddForm2() {
        // test
        // test
        // test
        // ~~~~~~
        return "memberAddForm";
    }


    @GetMapping("/form3")
    public String memberAddForm3() {
        // test
        // example
        return "memberAddForm";
    }



    @PostMapping("/form")
    public String memberAddForm(MemberAddForm memberAddForm) {
        Member member = new Member();
        member.setName(memberAddForm.getName());
        memberService.memberJoin(member);

        return "redirect:/list";
    }

    // here developer B
    // work
    // .....
    // ....~~~~~~~~



    @GetMapping("/list")
    public String list(Model model) {
        List<Member> list = memberService.findMembers();
        model.addAttribute("list", list);

        return "memberList";
    }

}
