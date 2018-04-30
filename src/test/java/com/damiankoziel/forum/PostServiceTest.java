package com.damiankoziel.forum;

import com.damiankoziel.forum.domain.Post;
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

    private PostService postService;

    @Test
    public void shouldCreatePostTest() {
        post = new Post();
        postService = new PostService(postRepository);
        postService.create(post);

        verify(postRepository).save(post);
    }

    @Test
    public void shouldGetAllPostsTest() {
        post = new Post();
        Post post2 = new Post();
        postService = new PostService(postRepository);
        postService.create(post);
        postService.create(post2);

        postService.getAll();
        verify(postRepository).findAll();
    }

    @Test
    public void shouldDeletePostByIdTest() {
        post = new Post();
        postService = new PostService(postRepository);
        postService.create(post);

        postService.delete(1L);
        verify(postRepository).deleteById(1L);
    }
}
