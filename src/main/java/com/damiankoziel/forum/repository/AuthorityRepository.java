package com.damiankoziel.forum.repository;

import com.damiankoziel.forum.commons.RoleName;
import com.damiankoziel.forum.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    Authority findByName(RoleName name);
}

