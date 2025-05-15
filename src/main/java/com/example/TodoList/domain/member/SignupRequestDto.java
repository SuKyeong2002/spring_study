package com.example.TodoList.domain.member;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
// json -> object
public class SignupRequestDto {

    @NotBlank
    String username;
    String password;
    String nickname;
}
