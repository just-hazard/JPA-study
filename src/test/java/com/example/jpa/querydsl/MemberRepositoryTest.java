package com.example.jpa.querydsl;

import com.querydsl.core.types.Predicate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void crud() {
        QMember qMember = QMember.member;
        Predicate predicate = qMember.firstName.containsIgnoreCase("seop").and(qMember.lastName.startsWith("hazard"));

        Optional<Member> findOne = memberRepository.findOne(predicate);
        assertThat(findOne).isEmpty();
    }
}