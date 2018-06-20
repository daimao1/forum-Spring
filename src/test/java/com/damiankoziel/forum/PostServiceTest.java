package com.damiankoziel.forum;

import com.damiankoziel.forum.model.Post;
import com.damiankoziel.forum.model.User;
import com.damiankoziel.forum.repository.CommentRepository;
import com.damiankoziel.forum.repository.PostRepository;
import com.damiankoziel.forum.service.PostService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class PostServiceTest {

    private Post post;

    @Mock
    private PostRepository postRepository;

    @Mock
    private CommentRepository commentRepository;

    private PostService postService;

    private User user = new User();

    @Test
    public void shouldCreatePostTest() {
        post = new Post();
        post.setUser(user);
        postService = new PostService(postRepository, commentRepository);
        postService.create(post);

        verify(postRepository).save(post);
    }

    @Test
    public void shouldGetAllPostsTest() {
        post = new Post();
        Post post2 = new Post();
        post.setUser(user);
        post2.setUser(user);
        postService = new PostService(postRepository, commentRepository);
        postService.create(post);
        postService.create(post2);

        postService.getAll();
        verify(postRepository).findAll();
    }

    @Test
    public void shouldDeletePostByIdTest() {
        post = new Post();
        postService = new PostService(postRepository, commentRepository);
        post.setUser(user);
        postService.create(post);
        postService.delete(1L);
        verify(postRepository).deleteById(1L);
    }
}
