package com.example.jpa.post;

import java.util.List;

public interface PostCustomSecondRepository<T> {

    List<Custom> findMyPost();

    void delete(T entity);
}
