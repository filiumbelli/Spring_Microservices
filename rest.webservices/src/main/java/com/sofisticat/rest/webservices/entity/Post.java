package com.sofisticat.rest.webservices.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Post implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post")
    @SequenceGenerator(allocationSize = 1, name = "post", sequenceName = "post_seq")
    private long post_id;
    private String message;
    private String title;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private User user;
}
