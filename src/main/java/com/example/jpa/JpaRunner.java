package com.example.jpa;

import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        Account account = new Account();
//        account.setUsername("seop");
//        account.setPassword("1234");
//
//        Study study = new Study();
//        study.setName("Sring Data JPA");
//
//        account.addStudy(study);
//
////        account.getStudies().add(study);
////        study.setOwner(account);
//
//        Session session = entityManager.unwrap(Session.class);
//
//        session.save(account);
//        session.save(study);

//        Post post = new Post();
//        post.setTitle("달려달려");
//
//        Comment comment = new Comment();
//        comment.setComment("달려달려2");
//        post.addComment(comment);
//
//        Comment comment1 = new Comment();
//        comment1.setComment("달려달려3");
//        post.addComment(comment1);

        Session session = entityManager.unwrap(Session.class);
        Post post = session.get(Post.class, 10L);
//        session.save(post);
        System.out.println("result : " + post.toString());

    }
}
