package com.damiankoziel.forum;

import com.damiankoziel.forum.model.Comment;
import com.damiankoziel.forum.repository.CommentRepository;
import com.damiankoziel.forum.service.CommentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;


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

/*    @Test
    public void shouldGetAllCommentsTest() {
        comment = new Comment();
        Comment comment2 = new Comment();
        commentService = new CommentService(commentRepository);
        commentService.create(comment);
        commentService.create(comment2);

        commentService.();
        verify(commentRepository).findAll();
    }*/

    @Test
    public void shouldDeleteCategoryTest() {
        comment = new Comment();
        commentService = new CommentService(commentRepository);
        commentService.create(comment);

        commentService.delete(1L);
        verify(commentRepository).deleteById(1L);
    }
}
