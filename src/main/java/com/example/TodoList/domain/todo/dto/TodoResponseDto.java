package com.example.TodoList.domain.todo.dto;

import com.example.TodoList.domain.todo.Todo;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TodoResponseDto {

    private Long todoId;

    private String title;
    private LocalDateTime date;
    private String writer;

    public TodoResponseDto (Todo todo) {
        this.todoId = todo.getTodoId();
        this.title = todo.getTitle();
        this.date = todo.getDate();
        this.writer = todo.getWriter().getNickname();
    }
}
