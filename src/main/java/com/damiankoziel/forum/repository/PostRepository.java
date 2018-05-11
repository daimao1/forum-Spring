package com.damiankoziel.forum.repository;

import com.damiankoziel.forum.domain.Post;
import com.damiankoziel.forum.dto.PostDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    Post findFirstByOrderByIdDesc();

}
