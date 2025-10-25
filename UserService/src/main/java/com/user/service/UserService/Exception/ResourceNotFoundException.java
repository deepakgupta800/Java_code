package com.user.service.UserService.Exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException() {
        super("Resource Not found Exception");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }

}
