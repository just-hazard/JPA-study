package com.example.jpa.post;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class Custom extends AbstractAggregateRoot<Custom> {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @Lob
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    public Custom publish() {
        this.registerEvent(new PostPublishedEvent(this));
        return this;
    }
}
