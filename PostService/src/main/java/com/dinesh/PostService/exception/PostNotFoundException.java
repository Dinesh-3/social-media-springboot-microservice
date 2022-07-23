package com.dinesh.PostService.exception;

public class PostNotFoundException extends RuntimeException{

    public PostNotFoundException() {
        super("Student Not Found");
    }

    public PostNotFoundException(String message) {
        super(message);
    }
}
