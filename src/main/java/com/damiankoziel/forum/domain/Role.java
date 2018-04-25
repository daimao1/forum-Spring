package com.damiankoziel.forum.domain;

import com.damiankoziel.forum.commons.RoleName;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
@AllArgsConstructor
public class Role {

    @Id
    private Long id;

    private RoleName roleName;

    @OneToOne(mappedBy = "role")
    private User user;
}
