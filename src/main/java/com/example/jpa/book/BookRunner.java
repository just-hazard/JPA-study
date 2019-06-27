package com.example.jpa.book;

import com.example.jpa.book.entity.Book;
import com.example.jpa.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookRunner implements ApplicationRunner {

    @Autowired
    BookRepository bookRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Book book = new Book();
        book.setId(1);
        book.setName("이름");
        bookRepository.save(book);
        book.setId(2);
        book.setName("이름2");
        bookRepository.save(book);

        List<Book> book1 = bookRepository.findAll();
        System.out.println("test : " + book1.size());
    }
}
