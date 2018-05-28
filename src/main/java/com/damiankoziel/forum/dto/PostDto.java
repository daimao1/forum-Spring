package com.damiankoziel.forum.dto;

import com.damiankoziel.forum.commons.Category;
import com.damiankoziel.forum.domain.Comment;
import com.damiankoziel.forum.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PostDto {
    private Long id;

    private String title;

    private String content;

    private LocalDateTime dateTimeOfPost;

    private String imageUrl;

    private Collection<Category> categories;

    private Integer ratingPoints;

//    private Collection<Comment> comments;
}
