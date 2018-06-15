package com.damiankoziel.forum.domain;

import com.damiankoziel.forum.commons.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime dateTimeOfPost = LocalDateTime.now();

    private String imageUrl;

    @ElementCollection
    private Collection<Category> categories;

    private Integer ratingPoints;

    @ManyToOne
    private User user;

}
