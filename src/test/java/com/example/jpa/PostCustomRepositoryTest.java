package com.example.jpa;

import com.example.jpa.post.Custom;
import com.example.jpa.post.CustomRepositoryTestConfig;
import com.example.jpa.post.PostCustomRepository;
import com.example.jpa.post.PostPublishedEvent;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@Import(CustomRepositoryTestConfig.class)
public class PostCustomRepositoryTest {

    @Autowired
    PostCustomRepository postCustomRepository;

    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void event() {
        Custom custom = new Custom();
        custom.setTitle("event");
        PostPublishedEvent event = new PostPublishedEvent(custom);

        applicationContext.publishEvent(event);
    }

    @Test
    public void findMyPost() {
        postCustomRepository.findMyPost();
    }


}
