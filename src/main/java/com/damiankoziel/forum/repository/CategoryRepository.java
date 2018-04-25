package com.damiankoziel.forum.repository;

import com.damiankoziel.forum.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
