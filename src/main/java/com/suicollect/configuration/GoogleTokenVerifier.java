package com.suicollect.configuration;

import com.nimbusds.jose.jwk.source.*;
import com.nimbusds.jose.jwk.*;
import com.nimbusds.jose.proc.*;
import com.nimbusds.jwt.proc.*;
import com.nimbusds.jwt.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.net.URL;

@Configuration
public class GoogleTokenVerifier {
    private static final String GOOGLE_ISSUER_1 = "https://accounts.google.com";
    private static final String GOOGLE_ISSUER_2 = "accounts.google.com";

    @Value("${spring.security.oauth2.client.registration.google.client-id}")
    private String clientId;

    private final ConfigurableJWTProcessor<com.nimbusds.jose.proc.SecurityContext> jwtProcessor;

    public GoogleTokenVerifier() throws Exception {
        JWKSource<com.nimbusds.jose.proc.SecurityContext> keySource =
                new RemoteJWKSet<>(new URL("https://www.googleapis.com/oauth2/v3/certs"));
        this.jwtProcessor = new DefaultJWTProcessor<>();
        JWSKeySelector<com.nimbusds.jose.proc.SecurityContext> keySelector =
                new JWSVerificationKeySelector<>(com.nimbusds.jose.JWSAlgorithm.RS256, keySource);
        jwtProcessor.setJWSKeySelector(keySelector);
    }

    public JWTClaimsSet verify(String idToken) throws Exception {
        JWTClaimsSet claims = jwtProcessor.process(idToken, null);

        // audience check
        if (!claims.getAudience().contains(clientId)) {
            throw new RuntimeException("Invalid audience");
        }

        // issuer check
        String iss = claims.getIssuer();
        if (!GOOGLE_ISSUER_1.equals(iss) && !GOOGLE_ISSUER_2.equals(iss)) {
            throw new RuntimeException("Invalid issuer");
        }

        Boolean emailVerified = (Boolean) claims.getClaim("email_verified");
        if (emailVerified == null || !emailVerified) {
            throw new RuntimeException("Email not verified");
        }

        return claims;
    }
}
