package com.example.TodoList.domain.todo;

import com.example.TodoList.domain.member.Member;
import com.example.TodoList.domain.member.MemberRepository;
import com.example.TodoList.domain.todo.dto.CreateRequestDto;
import com.example.TodoList.global.token.TokenGenerator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public void CreateTodo(CreateRequestDto createRequestDto) {

        String token = createRequestDto.getToken();
        Long id = TokenGenerator.decrypt(token);
        Member writerId = memberRepository.findById(id).orElse(null);

        Todo todo = Todo
                .builder()
                .title(createRequestDto.getTitle())
                .date(createRequestDto.getDate())
                .writer(writerId)
                .build();

        todoRepository.save(todo);
    }
}
