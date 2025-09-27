package com.suicollect.service;

public interface SessionTokenService {
    String generateSessionToken(String userId);
}
