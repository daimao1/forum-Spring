package com.damiankoziel.forum.model;

import com.damiankoziel.forum.commons.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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

    @NotNull
    @Size(min = 3, max = 40)
    private String title;

    @NotNull
    @Size(min = 5, max = 5000)
    @Column(columnDefinition = "TEXT")
    private String content;

    @NotNull
    private LocalDateTime dateTimeOfPost = LocalDateTime.now();

    private String imageUrl;

    @ElementCollection
    private Collection<Category> categories;

    @NotNull
    @Min(0)
    private Integer ratingPoints;

    @NotNull
    @ManyToOne
    private User user;

}
