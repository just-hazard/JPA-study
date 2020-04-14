package com.example.jpa.webfunction;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class WebFunction {

    @Id @GeneratedValue
    private Long id;

    private String title;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
}
