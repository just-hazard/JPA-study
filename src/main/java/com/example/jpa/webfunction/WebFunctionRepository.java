package com.example.jpa.webfunction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WebFunctionRepository extends JpaRepository<WebFunction,Long> {

    List<WebFunction> findByTitleStartsWith();

    @Modifying(clearAutomatically = true)
    @Query("UPDATE WebFunction w Set w.title = ?1 where w.id = ?2")
    int updateTitle(String title, Long id);
}
