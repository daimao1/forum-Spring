package com.damiankoziel.forum.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "users")
@Data
@AllArgsConstructor
public class User {

    @Id
    private Long id;

    private String username;

    private String password;

    private String email;

    private String firstName;

    private String lastName;

    @OneToOne
    @JoinColumn(name = "role_id")
    private Role role;

    private String avatarUrl;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dateOfSignUp;


    @OneToOne(mappedBy = "user")
    private Comment comment;
}
