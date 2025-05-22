package com.example.TodoList.domain.todo;

import com.example.TodoList.domain.member.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long todoId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member writer;

    @Column(nullable = false)
    private String title;

    @Builder.Default
    @Column(name = "is_checked", nullable = false)
    private Boolean check = false;

    @Column(name = "todo_date")
    private LocalDateTime date;

}
