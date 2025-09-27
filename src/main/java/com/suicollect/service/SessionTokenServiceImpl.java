package com.suicollect.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Service
public class SessionTokenServiceImpl implements SessionTokenService {

    private final Key key;

    public SessionTokenServiceImpl(@Value("${RESET_JWT_SECRET}") String secret) {
        this.key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public String generateSessionToken(String userId) {
        long now = System.currentTimeMillis();
        return Jwts.builder()
                .setSubject(userId)
                .setIssuedAt(new Date(now))
                .setExpiration(new Date(now + 7L * 24 * 60 * 60 * 1000)) // 7 days
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }
}

