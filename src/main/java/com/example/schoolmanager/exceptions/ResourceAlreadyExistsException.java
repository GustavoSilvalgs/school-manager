package com.example.schoolmanager.exceptions;

public class ResourceAlreadyExistsException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ResourceAlreadyExistsException(String ex) {
        super(ex);
    }
}
