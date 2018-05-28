package com.damiankoziel.forum.dto;

import com.damiankoziel.forum.domain.Post;
import com.damiankoziel.forum.domain.User;
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
