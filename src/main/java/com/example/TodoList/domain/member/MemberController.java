package com.example.TodoList.domain.member;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/member") // 어떤 주소를 받는 걸 spring container한테 알려줌
public class MemberController {
    @PostMapping("/signup")
    public void signup (@RequestBody @Valid SignupRequestDto requestDto) {
        Member member = new Member();
        System.out.println("회원가입");
        System.out.println(requestDto.username);
        System.out.println(requestDto.password);
        System.out.println(requestDto.nickname);
    }
}
