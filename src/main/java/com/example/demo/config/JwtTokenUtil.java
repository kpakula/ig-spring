package com.example.demo.config;

import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.function.Function;

/**
 * Jwt Token Util for creation and validation jwt token
 */
@Component
public class JwtTokenUtil {

    @Value("${jwt.token.expiration.time}")
    private long JWT_TOKEN_EXPIRATION_TIME;

    @Value("${jwt.secret}")
    private String secret;


    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }




}
