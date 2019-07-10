package com.example.jpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class CommonRepositoryTest {

    @Autowired
    CommonRepository commonRepository;

    @Test
    public void crud() {
        Comment comment = new Comment();
        comment.setComment("Hello Comment");
        commonRepository.save(comment);

        List<Comment> all = commonRepository.findAll();
        assertThat(all.size()).isEqualTo(1);

        long count = commonRepository.count();
        assertThat(count).isEqualTo(1);

        Optional<Comment> byId = commonRepository.findById(100L);
        assertThat(byId).isEmpty();
        Comment comment1 = byId.orElseThrow(IllegalAccessError::new);

        commonRepository.save(null);

    }
}