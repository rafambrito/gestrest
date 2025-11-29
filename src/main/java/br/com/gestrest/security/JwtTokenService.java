package br.com.gestrest.security;

import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import br.com.gestrest.entities.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenService {

    private final SecretKey key;
    private final long expirationMinutes;

    public JwtTokenService(
            @Value("${gestrest.jwt.secret}") String secret,
            @Value("${gestrest.jwt.expiration-minutes:60}") long expirationMinutes) {
        this.key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        this.expirationMinutes = expirationMinutes;
    }

    public String generateToken(User user) {
        Instant now = Instant.now();
        Instant exp = now.plus(expirationMinutes, ChronoUnit.MINUTES);

        return Jwts.builder()
                .subject(user.getLogin())
                .claim("uid", user.getUsuarioId())
                .claim("role", user.getTipoUsuarioId())
                .issuedAt(Date.from(now))
                .expiration(Date.from(exp))
                .signWith(key)
                .compact();
    }

    public Claims parseToken(String token) {
        return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}

