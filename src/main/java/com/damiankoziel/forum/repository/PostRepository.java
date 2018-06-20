package com.damiankoziel.forum.repository;

import com.damiankoziel.forum.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    Post findFirstByOrderByIdDesc();

}
