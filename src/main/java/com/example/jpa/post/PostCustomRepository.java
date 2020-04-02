package com.example.jpa.post;

import org.springframework.data.jpa.repository.JpaRepository;


public interface PostCustomRepository extends JpaRepository<Custom, Long>, PostCustomSecondRepository<Custom>{

}
