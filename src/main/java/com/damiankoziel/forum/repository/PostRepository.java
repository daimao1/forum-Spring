package com.damiankoziel.forum.repository;

import com.damiankoziel.forum.model.Post;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("from Post p order by p.dateTimeOfPost desc")
    Collection<Post> findAllSortedByDateReverse();

    Post findFirstByOrderByIdDesc();

    @Query("from Post p order by p.dateTimeOfPost desc")
    Page<Post> findAll(Pageable pageable);

}
