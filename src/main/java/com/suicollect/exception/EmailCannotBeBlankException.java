package com.suicollect.exception;

public class EmailCannotBeBlankException extends RuntimeException {
    public EmailCannotBeBlankException(String message) {
        super(message);
    }
}
