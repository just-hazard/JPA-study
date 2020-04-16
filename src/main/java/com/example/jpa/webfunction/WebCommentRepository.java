package com.example.jpa.webfunction;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface WebCommentRepository extends JpaRepository<WebComment, Long>, JpaSpecificationExecutor<WebComment> {

    @EntityGraph(value = "WebComment.webFunction")
    Optional<WebComment> getById(Long id);

    List<WebCommentSummary> findByWebFunction_Id(Long id);
}
