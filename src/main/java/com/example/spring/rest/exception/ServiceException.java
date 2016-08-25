package com.example.spring.rest.exception;

public class ServiceException extends Exception {
    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Exception exception) {
        super(exception.getMessage(), exception);
    }
}
