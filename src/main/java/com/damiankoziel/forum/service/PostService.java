package com.damiankoziel.forum.service;

import com.damiankoziel.forum.domain.DtoConverter.ToDtoConverter;
import com.damiankoziel.forum.domain.Post;
import com.damiankoziel.forum.dto.PostDto;
import com.damiankoziel.forum.exceptions.PostException;
import com.damiankoziel.forum.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(final PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostDto create(final Post post) {
        return ToDtoConverter.postToDto(this.postRepository.save(post));
    }

    public Iterable<PostDto> getAll() {
        return this.postRepository.findAll().stream()
                .map(ToDtoConverter::postToDto)
                .collect(Collectors.toList());
    }

    public PostDto getById(final Long id) {
        return ToDtoConverter.postToDto(this.postRepository.findById(id).orElseThrow(
                () -> new PostException("Post not found!")
        ));
    }

    public PostDto update(Post post) {
        this.postRepository.findById(post.getId()).orElseThrow(
                () -> new PostException("Post not found!")
        );
        return ToDtoConverter.postToDto(this.postRepository.save(post));
    }

    public void delete(Long id) {
        this.postRepository.findById(id).orElseThrow(
                () -> new PostException("Post not found!")
        );
        this.postRepository.deleteById(id);
    }


}
