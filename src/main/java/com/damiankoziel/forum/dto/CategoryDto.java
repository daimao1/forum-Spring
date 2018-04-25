package com.damiankoziel.forum.dto;

import com.damiankoziel.forum.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CategoryDto {
    private Long id;

    private String name;

    private Post post;
}
