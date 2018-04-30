package com.damiankoziel.forum.dto;

import com.damiankoziel.forum.domain.Post;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {
    private Long id;

    private String name;

    private Post post;
}
