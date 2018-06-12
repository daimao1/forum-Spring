package com.damiankoziel.forum.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String username;

    @Getter
    @Setter
    private String password;

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private String firstName;

    @Getter
    @Setter
    private String lastName;

    @Getter
    @Setter
    private Boolean isActive = true;

    @Getter
    @Setter
    private String avatarUrl;

    @Getter
    @Setter
    private LocalDate dateOfSignUp = LocalDate.now();

    @Getter
    @Setter
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Role role;
}
