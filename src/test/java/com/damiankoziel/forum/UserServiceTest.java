package com.damiankoziel.forum;

import com.damiankoziel.forum.model.User;
import com.damiankoziel.forum.repository.RoleRepository;
import com.damiankoziel.forum.repository.UserRepository;
import com.damiankoziel.forum.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    private User user;

    @Mock
    private UserRepository userRepository;

    @Mock
    private RoleRepository roleRepository;

    @Mock
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private UserService userService;

    @Test
    public void shouldCreateUserTest() {
        user = new User();
        userService = new UserService(userRepository, roleRepository, bCryptPasswordEncoder);
        userService.signUp(user);

        verify(userRepository).save(user);
    }

    @Test
    public void shouldGetAllCategoriesTest() {
        user = new User();
        User user2 = new User();
        userService = new UserService(userRepository, roleRepository, bCryptPasswordEncoder);
        userService.signUp(user);
        userService.signUp(user2);

        userService.getAll();
        verify(userRepository).findAll();
    }
}
