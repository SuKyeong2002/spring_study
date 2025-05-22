package com.example.TodoList.domain.todo.dto;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateRequestDto {

    // 헤더 대신 임시 token
    private String token;

    private String title;
    private LocalDateTime date;

}
