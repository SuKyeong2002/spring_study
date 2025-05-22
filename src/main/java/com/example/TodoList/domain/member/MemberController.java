package com.example.TodoList.domain.member;

import com.example.TodoList.domain.member.dto.LoginRequestDto;
import com.example.TodoList.domain.member.dto.SignupRequestDto;
import com.example.TodoList.domain.member.dto.TestDto;
import com.example.TodoList.global.token.TokenGenerator;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/member") // 어떤 주소를 받는 걸 spring container한테 알려줌
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signup")
    public void signup (@RequestBody @Valid SignupRequestDto requestDto) {
        memberService.signup(requestDto);
    }

    @PostMapping("/login")
    public String login (@RequestBody @Valid LoginRequestDto requestDto) {
        return memberService.login(requestDto);
    }

    @PostMapping("/test")
    public void test (@RequestBody TestDto testDto) {
        String token = testDto.getToken();
        System.out.println(TokenGenerator.decrypt(token));
    }
}
