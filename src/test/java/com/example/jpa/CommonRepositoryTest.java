package com.example.jpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class CommonRepositoryTest {

    @Autowired
    CommonRepository commonRepository;

    @Autowired
    CommentRepository commentRepository;


    @Test
    public void crud() throws ExecutionException, InterruptedException {
        Comment comment = new Comment();
        comment.setComment("Hello Comment");
        commonRepository.save(comment);

//        List<Comment> hello = commentRepository.findByCommentContainsIgnoreCase("Hello");
//        assertThat(hello.size()).isEqualTo(1);

        Future<List<Comment>> future =
                commentRepository.findByCommentContainsIgnoreCase("Hello");
        System.out.println("=========");
        System.out.println("is done?" + future.isDone());

        List<Comment> comments = future.get();
        comments.forEach(System.out::println);


//        List<Comment> all = commonRepository.findAll();
//        assertThat(all.size()).isEqualTo(1);
//
//        long count = commonRepository.count();
//        assertThat(count).isEqualTo(1);
//
//        Optional<Comment> byId = commonRepository.findById(100L);
//        assertThat(byId).isEmpty();
//        //Comment comment1 = byId.orElseThrow(IllegalAccessError::new);
//
//        commonRepository.save(null);


    }
}