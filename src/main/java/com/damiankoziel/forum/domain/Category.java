package com.damiankoziel.forum.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
@AllArgsConstructor
public class Category {

    @Id
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
}
