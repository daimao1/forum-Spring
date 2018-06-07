/*
package com.damiankoziel.forum.domain;

import com.damiankoziel.forum.commons.RoleName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue
    private Long id;

    private RoleName roleName;

    @OneToOne(mappedBy = "role")
    private User user;
}
*/
