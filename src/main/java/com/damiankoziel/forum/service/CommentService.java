package com.damiankoziel.forum.service;

import com.damiankoziel.forum.domain.Comment;
import com.damiankoziel.forum.domain.DtoConverter.ToDtoConverter;
import com.damiankoziel.forum.dto.CommentDto;
import com.damiankoziel.forum.exceptions.CommentException;
import com.damiankoziel.forum.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public CommentDto create(final Comment comment) {
        return ToDtoConverter.commentToDto(this.commentRepository.save(comment));
    }

    public Iterable<CommentDto> getAll() {
        return this.commentRepository.findAll().stream()
                .map(ToDtoConverter::commentToDto)
                .collect(Collectors.toList());
    }

    public CommentDto getById(final Long id) {
        return ToDtoConverter.commentToDto(this.commentRepository.findById(id).orElseThrow(
                () -> new CommentException("Comment not found!")
                )
        );
    }

    public CommentDto update(final Comment comment) {
        this.commentRepository.findById(comment.getId()).orElseThrow(
                () -> new CommentException("Comment not found!")
        );
        return ToDtoConverter.commentToDto(this.commentRepository.save(comment));
    }

    public void delete(final Long id) {
        this.commentRepository.findById(id).orElseThrow(
                () -> new CommentException("Comment not found!")
        );
        this.commentRepository.deleteById(id);
    }
}
