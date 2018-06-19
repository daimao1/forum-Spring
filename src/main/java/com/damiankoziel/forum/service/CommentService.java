package com.damiankoziel.forum.service;

import com.damiankoziel.forum.domain.Comment;
import com.damiankoziel.forum.dto.DtoConverter.ToDtoConverter;
import com.damiankoziel.forum.dto.CommentDto;
import com.damiankoziel.forum.exceptions.CommentException;
import com.damiankoziel.forum.repository.CommentRepository;
import com.damiankoziel.forum.security.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(final CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    //    @PreAuthorize("hasRole('USER')")
    public CommentDto create(final Comment comment) {
        this.commentRepository.save(comment);
        return ToDtoConverter.commentToDto(comment);
    }

    public List<CommentDto> getAllByPostId(final Long id) {
        Collection<Comment> foundComments = this.commentRepository.findByPost_Id(id);
        return foundComments.stream()
                .sorted(Comparator.comparing(Comment::getDateTimeOfComment).reversed())
                .map(ToDtoConverter::commentToDto)
                .collect(Collectors.toList());
    }

    @PreAuthorize("hasRole('USER')")
    public CommentDto update(final Comment comment) {
        this.commentRepository.findById(comment.getId()).orElseThrow(
                () -> new CommentException("Can't update. Comment not found!")
        );
        this.commentRepository.save(comment);
        return ToDtoConverter.commentToDto(comment);
    }

    @PreAuthorize("hasRole('USER')")
    public void delete(final Long id) {
        this.commentRepository.deleteById(id);
    }
}
