package com.damiankoziel.forum;

import com.damiankoziel.forum.controller.PostController;
import com.damiankoziel.forum.model.Post;
import com.damiankoziel.forum.service.PostService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class PostControllerTest {

    private Post post;

    @Mock
    private PostService postService;

    private PostController postController;

    @Test
    public void shouldCreatePostTest() {
        post = new Post();
        postController = new PostController(postService);
        postController.createPost(post);

        verify(postService).create(post);
    }

    @Test
    public void shouldGetAllPostsTest() {
        post = new Post();
        Post post2 = new Post();
        postController = new PostController(postService);
        postController.createPost(post);
        postController.createPost(post2);

        postController.getAllPosts();
        verify(postService).getAll();
    }

    @Test
    public void shouldGetPostById() {
        post = new Post();
        postController = new PostController(postService);
        postController.createPost(post);

        postController.getPostById(1L);
        verify(postService).getById(1L);
    }

    @Test
    public void shouldDeletePostById() {
        post = new Post();
        postController = new PostController(postService);
        postController.createPost(post);

        postController.deletePostById(1L);
        verify(postService).delete(1L);
    }
}
