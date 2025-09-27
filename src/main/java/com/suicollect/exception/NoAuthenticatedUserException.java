package com.suicollect.exception;

public class NoAuthenticatedUserException extends RuntimeException {
    public NoAuthenticatedUserException(String message) {
        super(message);
    }
}
