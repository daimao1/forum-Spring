package com.damiankoziel.forum.dto;

import com.damiankoziel.forum.domain.Authority;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class UserDto {
    private Long id;

    private String username;

    private String email;

    private String firstName;

    private String lastName;

    private Boolean isActive;

    private String avatarUrl;

    private LocalDate dateOfSignUp;

    private List<Authority> authorities;
}
