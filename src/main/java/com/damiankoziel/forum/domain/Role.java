package com.damiankoziel.forum.domain;

import com.damiankoziel.forum.commons.RoleName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Data
public class Role implements GrantedAuthority {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @JsonIgnore
    Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "name")

    @JsonIgnore
    RoleName name;

    @Override
    public String getAuthority() {
        return name.name();
    }

}