package com.damiankoziel.forum.model;

import com.damiankoziel.forum.commons.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
@Indexed
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue
    private Long id;

    @Field
    @NotNull
    @Size(min = 3, max = 40)
    private String title;

    @Field
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
