package com.example.jpa.webfunction;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@NamedEntityGraph(name = "WebComment.webFunction", attributeNodes = @NamedAttributeNode(("webFunction")))
@Entity
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

}
