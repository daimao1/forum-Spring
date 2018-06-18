package com.damiankoziel.forum.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

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
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLES", joinColumns = {
            @JoinColumn(name = "USER_ID")}, inverseJoinColumns = {
            @JoinColumn(name = "ROLE_ID")})
    private Set<Role> roles;
}
