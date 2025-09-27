package com.suicollect.exception;

public class VoiceProcessingFailedException extends RuntimeException {
    public VoiceProcessingFailedException(String message) {
        super(message);
    }
}
