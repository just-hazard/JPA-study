package com.example.jpa.webfunction;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;

@NamedEntityGraph(name = "WebComment.webFunction", attributeNodes = @NamedAttributeNode(("webFunction")))
@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class WebComment {

    @Id @GeneratedValue
    private Long id;

    private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    private WebFunction webFunction;

    private int up;

    private int down;

    private boolean best;

    @CreatedDate
    private LocalDate created;

    @CreatedBy
    @ManyToOne
    private WebAccount createdBy;

    @LastModifiedDate
    private LocalDate updated;

    @LastModifiedBy
    @ManyToOne
    private WebAccount updatedBy;

    @PrePersist
    public void prePersist() {
        System.out.println("Pre Persist is called");
    }

}
