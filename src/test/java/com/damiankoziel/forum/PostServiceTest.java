package com.damiankoziel.forum;

import com.damiankoziel.forum.model.Post;
import com.damiankoziel.forum.model.User;
import com.damiankoziel.forum.repository.CommentRepository;
import com.damiankoziel.forum.repository.PostRepository;
import com.damiankoziel.forum.repository.PostSearch;
import com.damiankoziel.forum.service.PostService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class PostServiceTest {

    private Post post;

    @Mock
    private PostRepository postRepository;

    @Mock
    private CommentRepository commentRepository;

    @Mock
    private PostSearch postSearch;

    @Mock
    private User user;

    @Mock
    private MultipartFile file;

    private PostService postService;

    @Test
    public void shouldCreatePostTest() {
        post = new Post();
        post.setUser(user);
        postService = new PostService(postRepository, commentRepository, postSearch);
        postService.create(post);

        verify(postRepository).save(post);
    }

    @Test
    public void shouldGetAllPostsTest() {
        post = new Post();
        Post post2 = new Post();
        post.setUser(user);
        post2.setUser(user);
        postService = new PostService(postRepository, commentRepository, postSearch);
        postService.create(post);
        postService.create(post2);

        postService.getAll();
        verify(postRepository).findAllSortedByDateReverse();
    }

    @Test
    public void shouldDeletePostByIdTest() {
        post = new Post();
        postService = new PostService(postRepository, commentRepository, postSearch);
        post.setUser(user);
        postService.create(post);
        postService.delete(1L);
        verify(postRepository).deleteById(1L);
    }
}
