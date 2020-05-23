package com.easywaldo.book.springboot.web;

import com.easywaldo.book.springboot.domain.members.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Controller
public class MemberController {

    @GetMapping(path = "/member/index")
    public ModelAndView Member() {

        Member member = Member.builder()
                .id(UUID.randomUUID())
                .firstAddress("loc-first")
                .secondAddress("loc-second")
                .name("easywaldo")
                .build();
        ModelAndView modelAndView = new ModelAndView("Index");
        modelAndView.addObject("sample", member);

        return modelAndView;
    }
}
