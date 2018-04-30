package com.damiankoziel.forum;

import com.damiankoziel.forum.controller.CommentController;
import com.damiankoziel.forum.domain.Comment;
import com.damiankoziel.forum.service.CommentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CommentControllerTest {

    private Comment comment;

    @Mock
    private CommentService commentService;

    private CommentController commentController;

    @Test
    public void shouldCreateCommentTest() {
        comment = new Comment();
        commentController = new CommentController(commentService);
        commentController.createComment(comment);

        verify(commentService).create(comment);
    }

    @Test
    public void shouldGetAllCategoriesTest() {
        comment = new Comment();
        Comment comment2 = new Comment();
        commentController = new CommentController(commentService);
        commentController.createComment(comment);
        commentController.createComment(comment2);

        commentController.getAllComments();
        verify(commentService).getAll();
    }

    @Test
    public void shouldGetCommentById() {
        comment = new Comment();
        commentController = new CommentController(commentService);
        commentController.createComment(comment);

        commentController.getCommentById(1L);
        verify(commentService).getById(1L);
    }

    @Test
    public void shouldDeleteCommentById() {
        comment = new Comment();
        commentController = new CommentController(commentService);
        commentController.createComment(comment);

        commentController.deleteCommentById(1L);
        verify(commentService).delete(1L);
    }
}
