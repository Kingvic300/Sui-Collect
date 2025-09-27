package com.suicollect.exception;

public class OTPCannotBeBlankException extends RuntimeException {
    public OTPCannotBeBlankException(String message) {
        super(message);
    }
}
