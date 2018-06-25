package com.damiankoziel.forum.service;

import com.damiankoziel.forum.model.Comment;
import com.damiankoziel.forum.dto.DtoConverter.ToDtoConverter;
import com.damiankoziel.forum.model.Post;
import com.damiankoziel.forum.dto.PostDto;
import com.damiankoziel.forum.exceptions.PostException;
import com.damiankoziel.forum.repository.CommentRepository;
import com.damiankoziel.forum.repository.PostRepository;
import com.damiankoziel.forum.repository.PostSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final PostSearch postSearch;

    @Autowired
    public PostService(final PostRepository postRepository, final CommentRepository commentRepository, final PostSearch postSearch) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
        this.postSearch = postSearch;
    }

    //    @PreAuthorize("hasRole('USER')")
    public PostDto create(final Post post) {
        this.postRepository.save(post);
        return ToDtoConverter.postToDto(post);
    }

    public Collection<PostDto> getAll() {

        Collection<Post> posts = this.postRepository.findAllSortedByDateReverse();
        return posts.stream()
                .map(ToDtoConverter::postToDto)
                .collect(Collectors.toList());
    }

    public PostDto getById(final Long id) {
        Post post = this.postRepository.findById(id).orElseThrow(
                () -> new PostException("Can't get. Post not found!"));
        return ToDtoConverter.postToDto(post);
    }

    public Collection<PostDto> getAllPaginated(Integer pageNumber) {
        Integer index = pageNumber - 1;
        Page<Post> posts = this.postRepository.findAll(PageRequest.of(index, 20));
        return posts.stream().map(ToDtoConverter::postToDto).collect(Collectors.toList());
    }

    //
    @PreAuthorize("hasRole('USER')")
    public PostDto update(final Post post) {
        this.postRepository.findById(post.getId()).orElseThrow(
                () -> new PostException("Can't update. Post not found!")
        );
        this.postRepository.save(post);
        return ToDtoConverter.postToDto(post);
    }

    @PreAuthorize("hasRole('USER')")
    public void delete(final Long id) {
        Collection<Comment> relatedComments = commentRepository.findByPost_Id(id);
        if (relatedComments.size() > 0) {
            for (Comment comment : relatedComments) {
                commentRepository.deleteById(comment.getId());
            }
        }
        this.postRepository.deleteById(id);
    }

    public void uploadImage(final MultipartFile file) throws IOException {
        UUID imgGeneratedId = UUID.nameUUIDFromBytes(file.getBytes());
        File convertFile = new File("src/main/frontend/src/assets/images/" + imgGeneratedId + file.getOriginalFilename());
        Post foundPost = postRepository.findFirstByOrderByIdDesc();
        foundPost.setImageUrl("./assets/images/" + imgGeneratedId + file.getOriginalFilename());
        convertFile.createNewFile();
        FileOutputStream fout = new FileOutputStream(convertFile);
        fout.write(file.getBytes());
        fout.close();
        postRepository.save(foundPost);
    }

    @PreAuthorize("hasRole('USER')")
    public void rate(final Long id, final Integer buttonState) {
        Post foundPost = postRepository.findById(id).get();
        if (buttonState.equals(0)) {
            foundPost.setRatingPoints(foundPost.getRatingPoints() - 1);
        } else if (buttonState.equals(1)) {
            foundPost.setRatingPoints(foundPost.getRatingPoints() + 1);
        }
        postRepository.save(foundPost);
    }

    @SuppressWarnings("unchecked")
    public Collection search(String q) {
        Collection<Post> searchResults;
        try {
            System.out.println(postSearch.search(q));
            searchResults = postSearch.search(q);
            return searchResults.stream().map(ToDtoConverter::postToDto).collect(Collectors.toList());
        } catch (Exception ignored) {

        }
        return null;
    }
}
