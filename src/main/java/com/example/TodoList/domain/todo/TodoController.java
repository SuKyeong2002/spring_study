package com.example.TodoList.domain.todo;

import com.example.TodoList.domain.todo.dto.CreateRequestDto;
import com.example.TodoList.domain.todo.dto.TodoResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/todo")
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @PostMapping()
    public void createTodo (@RequestBody @Valid CreateRequestDto createRequestDto) {
        todoService.createTodo(createRequestDto);
    }

    @GetMapping()
    public List<TodoResponseDto> readTodos () {
        return todoService.readTodos();
    }

}
