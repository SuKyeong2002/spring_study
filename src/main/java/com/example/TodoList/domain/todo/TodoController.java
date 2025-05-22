package com.example.TodoList.domain.todo;

import com.example.TodoList.domain.todo.dto.CreateRequestDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/todo")
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @PostMapping()
    public void createTodo (@RequestBody @Valid CreateRequestDto createRequestDto) {
        todoService.CreateTodo(createRequestDto);
    }

}
