package com.damiankoziel.forum.repository;

import com.damiankoziel.forum.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
