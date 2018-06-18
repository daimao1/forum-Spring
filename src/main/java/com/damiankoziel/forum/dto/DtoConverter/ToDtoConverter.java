package com.damiankoziel.forum.dto.DtoConverter;

import com.damiankoziel.forum.domain.Comment;
import com.damiankoziel.forum.domain.Post;
import com.damiankoziel.forum.domain.User;
import com.damiankoziel.forum.dto.CommentDto;
import com.damiankoziel.forum.dto.PostDto;
import com.damiankoziel.forum.dto.UserDto;

import java.util.List;

public final class ToDtoConverter {

    private ToDtoConverter() {

    }

    public static CommentDto commentToDto(final Comment comment) {
        return new CommentDto(
                comment.getId(),
                comment.getContent(),
                comment.getDateTimeOfComment(),
                comment.getUser(),
                comment.getPost()
        );
    }

    public static PostDto postToDto(final Post post) {
        return new PostDto(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getDateTimeOfPost(),
                post.getImageUrl(),
                post.getCategories(),
                post.getRatingPoints(),
                userToDto(post.getUser())
                );
    }

    public static UserDto userToDto(final User user) {
        return new UserDto(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getFirstName(),
                user.getLastName(),
                user.getIsActive(),
                user.getAvatarUrl(),
                user.getDateOfSignUp(),
                user.getRoles()
        );
    }

}
