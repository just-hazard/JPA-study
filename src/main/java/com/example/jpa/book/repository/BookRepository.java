package com.example.jpa.book.repository;

import com.example.jpa.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
