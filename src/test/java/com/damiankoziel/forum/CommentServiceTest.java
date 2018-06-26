package com.damiankoziel.forum;

import com.damiankoziel.forum.model.Comment;
import com.damiankoziel.forum.model.Post;
import com.damiankoziel.forum.model.User;
import com.damiankoziel.forum.repository.CommentRepository;
import com.damiankoziel.forum.service.CommentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDateTime;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class CommentServiceTest {

    private Comment comment;

    @Mock
    private CommentRepository commentRepository;

    private CommentService commentService;

    @Test
    public void shouldCreateCommentTest() {
        comment = new Comment();
        commentService = new CommentService(commentRepository);
        commentService.create(comment);

        verify(commentRepository).save(comment);
    }

    @Test
    public void shouldGetAllCommentsByPostId() {
        comment = new Comment();
        Comment comment2 = new Comment();
        commentService = new CommentService(commentRepository);
        Post post = new Post();
        comment.setPost(post);
        comment2.setPost(post);
        commentService.create(comment);
        commentService.create(comment2);
        commentService.getAllByPostId(post.getId());

        verify(commentRepository).findByPost_Id(post.getId());
    }

    @Test
    public void shouldDeleteCategoryTest() {
        comment = new Comment();
        commentService = new CommentService(commentRepository);
        commentService.create(comment);

        commentService.delete(1L);
        verify(commentRepository).deleteById(1L);
    }
}
