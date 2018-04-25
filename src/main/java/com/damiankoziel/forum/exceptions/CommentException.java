package com.damiankoziel.forum.exceptions;

public class CommentException extends RuntimeException {
    public CommentException(final String commentNotFound) {
        super(commentNotFound);
    }
}
