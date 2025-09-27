package com.suicollect.exception;

public class EmailNotSentException extends RuntimeException {
    public EmailNotSentException(String message) {
        super(message);
    }
}
