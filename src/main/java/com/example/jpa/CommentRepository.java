package com.example.jpa;

import com.example.jpa.book.MyRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends MyRepository<Comment, Long> {


    List<Comment> findByCommentContains(String keyword);
}
