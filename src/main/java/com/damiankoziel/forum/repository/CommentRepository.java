package com.damiankoziel.forum.repository;

import com.damiankoziel.forum.domain.Comment;
import com.damiankoziel.forum.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    Collection<Comment> findByPost_Id(Long postId);
}
