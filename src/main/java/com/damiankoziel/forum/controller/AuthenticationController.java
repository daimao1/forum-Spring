package com.damiankoziel.forum.controller;

import com.damiankoziel.forum.dto.DtoConverter.ToDtoConverter;
import com.damiankoziel.forum.dto.UserDto;
import com.damiankoziel.forum.security.JwtTokenUtil;
import com.damiankoziel.forum.domain.AuthToken;
import com.damiankoziel.forum.domain.LoginUser;
import com.damiankoziel.forum.domain.User;
import com.damiankoziel.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/token")
public class AuthenticationController {
    private String currentUsername;

    private AuthenticationManager authenticationManager;

    private JwtTokenUtil jwtTokenUtil;

    private UserService userService;

    @Autowired
    public AuthenticationController(final AuthenticationManager authenticationManager, final JwtTokenUtil jwtTokenUtil, final UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userService = userService;
    }

    @RequestMapping(value = "/generate-token", method = RequestMethod.POST)
    public ResponseEntity<?> register(@RequestBody final LoginUser loginUser) throws AuthenticationException {

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getUsername(),
                        loginUser.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final User user = userService.findOne(loginUser.getUsername());
        final String token = jwtTokenUtil.generateToken(user);
        currentUsername = jwtTokenUtil.getUsernameFromToken(token);

        return ResponseEntity.ok(new AuthToken(token));
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/current-user")
    public ResponseEntity<UserDto> getCurrentUser() {
        UserDto userDto = ToDtoConverter.userToDto(userService.findOne(currentUsername));
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

}
