package com.example.jpa.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class PostCustomSecondRepositoryImpl implements PostCustomSecondRepository<Custom> {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<Custom> findMyPost() {
        return entityManager.createQuery("select p from Post as p")
                .getResultList();
    }

    @Override
    public void delete(Custom entity) {
        entityManager.remove(entity);
    }
}
