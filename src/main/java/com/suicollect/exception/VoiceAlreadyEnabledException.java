package com.suicollect.exception;

public class VoiceAlreadyEnabledException extends RuntimeException {
    public VoiceAlreadyEnabledException(String message) {
        super(message);
    }
}
