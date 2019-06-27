package com.example.jpa;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Account {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String username;

    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created_time = new Date();

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "owner")
    private Set<Study> studies = new HashSet<>();

    public void addStudy(Study study) {
        this.getStudies().add(study);
        study.setOwner(this);
    }

    public void removeStudy(Study study) {
        this.getStudies().remove(study);
        study.setOwner(null);
    }
}
