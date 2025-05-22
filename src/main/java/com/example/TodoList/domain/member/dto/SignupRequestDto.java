package com.example.TodoList.domain.member.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
// json -> object
public class SignupRequestDto {

    @NotBlank
    public String loginId;
    public String password;
    public String nickname;
}
