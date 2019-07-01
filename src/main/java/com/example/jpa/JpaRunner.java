package com.example.jpa;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    PostRepository postRepository;

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

        // 챕터7 쿼리
        TypedQuery<Post> query = entityManager.createQuery("select p from Post as p",Post.class);
        List<Post> posts = query.getResultList();
        posts.forEach(System.out::println);

        // 챕터8 JPA를 사용하는 방법
        postRepository.findAll().forEach(System.out::println);

        Post post = new Post();
        post.setTitle("JPA");

        Comment comment = new Comment();
        comment.setComment("Study");

        postRepository.save(post);


//        Session session = entityManager.unwrap(Session.class);
//        Post post = session.get(Post.class, 10L);
//        session.save(post);
//        System.out.println("result : " + post.toString());

    }
}
