package com.damiankoziel.forum;

import com.damiankoziel.forum.domain.User;
import com.damiankoziel.forum.repository.UserRepository;
import com.damiankoziel.forum.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    private User user;

    @Mock
    private UserRepository userRepository;

    private UserService userService;

    @Test
    public void shouldCreateUserTest() {
        user = new User();
        userService = new UserService(userRepository);
        userService.create(user);

        verify(userRepository).save(user);
    }

    @Test
    public void shouldGetAllCategoriesTest() {
        user = new User();
        User user2 = new User();
        userService = new UserService(userRepository);
        userService.create(user);
        userService.create(user2);

        userService.getAll();
        verify(userRepository).findAll();
    }
}
