package com.example.TodoList.domain.todo;

import com.example.TodoList.domain.member.Member;
import com.example.TodoList.domain.member.MemberRepository;
import com.example.TodoList.domain.todo.dto.CreateRequestDto;
import com.example.TodoList.domain.todo.dto.TodoResponseDto;
import com.example.TodoList.global.token.TokenGenerator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;
    private final MemberRepository memberRepository;

    // 생성
    @Transactional
    public void createTodo(CreateRequestDto createRequestDto) {

        String token = createRequestDto.getToken();
        Long id = TokenGenerator.decrypt(token);
        Member writerId = memberRepository.findById(id).orElse(null); // 단일 객체

//        Todo todo = Todo
//                .builder()
//                .title(createRequestDto.getTitle())
//                .date(createRequestDto.getDate())
//                .writer(writerId)
//                .build();

        Todo todo = new Todo();
        todo.setTitle(createRequestDto.getTitle());
        todo.setDate(createRequestDto.getDate());
        todo.setWriter(writerId);

        todoRepository.save(todo);
    }

    // 조회
    public List<TodoResponseDto> readTodos() {
        List<Todo> todos = todoRepository.findAll(); // 여러 개는 List로 받아야 함
        List<TodoResponseDto> responseDtos = new ArrayList<>();

        for (Todo todo : todos) {
            TodoResponseDto dto = new TodoResponseDto(todo);
            responseDtos.add(dto);
        }
        return responseDtos;
    }
}
