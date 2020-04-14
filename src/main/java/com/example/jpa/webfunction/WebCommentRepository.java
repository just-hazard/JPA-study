package com.example.jpa.webfunction;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WebCommentRepository extends JpaRepository<WebComment, Long> {

    @EntityGraph(value = "WebComment.webFunction")
    Optional<WebComment> getById(Long id);
}
