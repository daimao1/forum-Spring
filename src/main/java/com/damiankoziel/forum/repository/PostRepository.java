package com.damiankoziel.forum.repository;

import com.damiankoziel.forum.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
