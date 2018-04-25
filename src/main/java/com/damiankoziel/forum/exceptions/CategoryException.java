package com.damiankoziel.forum.exceptions;

public class CategoryException extends RuntimeException {
    public CategoryException(final String categoryNotFound) {
        super(categoryNotFound);
    }
}
