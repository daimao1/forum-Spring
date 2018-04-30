package com.damiankoziel.forum.service;

import com.damiankoziel.forum.domain.Comment;
import com.damiankoziel.forum.dto.DtoConverter.ToDtoConverter;
import com.damiankoziel.forum.dto.CommentDto;
import com.damiankoziel.forum.exceptions.CommentException;
import com.damiankoziel.forum.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(final CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public CommentDto create(final Comment comment) {
        this.commentRepository.save(comment);
        return ToDtoConverter.commentToDto(comment);
    }

    public Collection<CommentDto> getAll() {
        Collection<Comment> comments = this.commentRepository.findAll();
        return comments.stream()
                .map(ToDtoConverter::commentToDto)
                .collect(Collectors.toList());
    }

    public CommentDto getById(final Long id) {
        Comment comment = this.commentRepository.findById(id).orElseThrow(
                () -> new CommentException("Can't get. Comment not found!")
        );
        return ToDtoConverter.commentToDto(comment);
    }

    public CommentDto update(final Comment comment) {
        this.commentRepository.findById(comment.getId()).orElseThrow(
                () -> new CommentException("Can't update. Comment not found!")
        );
        this.commentRepository.save(comment);
        return ToDtoConverter.commentToDto(comment);
    }

    public void delete(final Long id) {
        this.commentRepository.deleteById(id);
    }
}
