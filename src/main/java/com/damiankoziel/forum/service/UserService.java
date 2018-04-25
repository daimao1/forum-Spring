package com.damiankoziel.forum.service;

import com.damiankoziel.forum.domain.DtoConverter.ToDtoConverter;
import com.damiankoziel.forum.domain.User;
import com.damiankoziel.forum.dto.UserDto;
import com.damiankoziel.forum.exceptions.UserException;
import com.damiankoziel.forum.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto create(final User user) {
        return ToDtoConverter.userToDto(this.userRepository.save(user));
    }

    public Iterable<UserDto> getAll() {
        return this.userRepository.findAll().stream()
                .map(ToDtoConverter::userToDto)
                .collect(Collectors.toList());
    }

    public UserDto getById(Long id) {
        return ToDtoConverter.userToDto(this.userRepository.findById(id).orElseThrow(
                () -> new UserException("User not found!")
                )
        );
    }

    public UserDto update(final User user) {
        this.userRepository.findById(user.getId()).orElseThrow(
                () -> new UserException("User not found!")
        );
        return ToDtoConverter.userToDto(this.userRepository.save(user));
    }

    public void delete(final Long id) {
        this.userRepository.findById(id).orElseThrow(
                () -> new UserException("User not found!")
        );
        this.userRepository.deleteById(id);
    }

    public UserDto getByUsername(String username) {
        return ToDtoConverter.userToDto((User) this.userRepository.findByUsername(username));
    }


}
