package com.example.TodoList.domain.member;

import com.example.TodoList.domain.member.dto.LoginRequestDto;
import com.example.TodoList.domain.member.dto.SignupRequestDto;
import com.example.TodoList.global.token.TokenGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public void signup(SignupRequestDto requestDto) {

        Member member = Member
                .builder()
                .loginId(requestDto.loginId)
                .password(requestDto.password)
                .nickname(requestDto.nickname)
                .build();
        memberRepository.save(member);
        System.out.println("회원가입 성공 ~~~ ");
    }

    public String login(LoginRequestDto requestDto) {

        Member loginMember = memberRepository.findByLoginId(requestDto.getLoginId());

        if (!Objects.equals(requestDto.getPassword(), loginMember.getPassword())) {
            System.out.println("로그인 실패!" + requestDto.getLoginId() + "님의 현재 비밀번호는 " + loginMember.getPassword() + "입니다");
            return "실패";
        }
        System.out.println(requestDto.getLoginId() + "님의 로그인을 축하합니다!" );
        return TokenGenerator.encryptId(loginMember.getUserId());
    }
}
