package com.damiankoziel.forum.domain;

import com.damiankoziel.forum.commons.RoleName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "AUTHORITY")
public class Authority implements GrantedAuthority {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "name")
    RoleName name;

    @Override
    public String getAuthority() {
        return name.name();
    }

    public void setName(RoleName name) {
        this.name = name;
    }

    @JsonIgnore
    public RoleName getName() {
        return name;
    }

    @JsonIgnore
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}