package com.example.jpa.book.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
public class Book {

    @Id @GeneratedValue
    private int id;

    private String name;

    private LocalDateTime createdTime;
}
