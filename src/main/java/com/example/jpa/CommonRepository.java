package com.example.jpa;

import com.example.jpa.book.MyRepository;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.List;
import java.util.Optional;

@RepositoryDefinition(domainClass = Comment.class, idClass = Long.class)
public interface CommonRepository extends MyRepository<Comment, Long> {

    Comment save(Comment comment);

    List<Comment> findAll();

    long count();



}
