package com.example.TodoList.domain.member;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {


    Member findByLoginId(@NotBlank String loginId);
}
