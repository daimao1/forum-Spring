package com.damiankoziel.forum.dto.DtoConverter;

import com.damiankoziel.forum.domain.Category;
import com.damiankoziel.forum.domain.Comment;
import com.damiankoziel.forum.domain.Post;
import com.damiankoziel.forum.domain.User;
import com.damiankoziel.forum.dto.CategoryDto;
import com.damiankoziel.forum.dto.CommentDto;
import com.damiankoziel.forum.dto.PostDto;
import com.damiankoziel.forum.dto.UserDto;

public final class ToDtoConverter {

    private ToDtoConverter() {

    }

    public static CategoryDto categoryToDto(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        categoryDto.setPost(category.getPost());
        return categoryDto;
    }

    public static CommentDto commentToDto(Comment comment) {
        return new CommentDto(
                comment.getId(),
                comment.getContent(),
                comment.getDateTimeOfComment(),
                comment.getUser()
        );
    }

    public static PostDto postToDto(Post post) {
        return new PostDto(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getDateTimeOfPost(),
                post.getImageUrl(),
                post.getCategories()
                );
    }

    public static UserDto userToDto(User user) {
        return new UserDto(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getFirstName(),
                user.getLastName(),
                user.getIsActive(),
                user.getRole(),
                user.getAvatarUrl(),
                user.getDateOfSignUp(),
                user.getComment()
        );
    }

}
