package com.example.jpa.webfunction;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class WebCommentRepositoryTest {

    @Autowired
    WebCommentRepository webCommentRepository;

    @Autowired
    WebFunctionRepository webFunctionRepository;

    @Test
    public void getComment() {
//        WebFunction webFunction = new WebFunction();
//        webFunction.setTitle("jpa");
//        WebFunction save = webFunctionRepository.save(webFunction);
//
//
//        WebComment webComment = new WebComment();
//        webComment.setComment("comment");
//        webComment.setWebFunction(save);
//        webCommentRepository.save(webComment);
//
//        Optional<WebComment> byId = webCommentRepository.findById(1l);

        webCommentRepository.getById(1l);

        System.out.println("===========================");

        webCommentRepository.findById(1l);

    }

}