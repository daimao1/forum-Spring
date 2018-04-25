package com.damiankoziel.forum.dto;

import com.damiankoziel.forum.domain.Comment;
import com.damiankoziel.forum.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class UserDto {
    private Long id;

    private String username;

    private String email;

    private String firstName;

    private String lastName;

    private Role role;

    private String avatarUrl;

    private LocalDate dateOfSignUp;

    private Comment comment;
}
