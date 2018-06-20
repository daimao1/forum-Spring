package com.damiankoziel.forum.dto;

import com.damiankoziel.forum.model.Post;
import com.damiankoziel.forum.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class CommentDto {
    private Long id;

    private String content;

    private LocalDateTime dateTimeOfComment;

    private User user;

    private Post post;
}
