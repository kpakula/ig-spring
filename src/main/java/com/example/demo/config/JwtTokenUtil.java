package com.example.demo.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
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

    /**
     * Method to get username from a token
     * @param token This is the token currently being processed
     * @return Generic class
     */
    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    /**
     * Method to get token expiration date
     * @param token This is the token currently being processed
     * @return Generic class
     */
    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    /**
     * Method to get information from token by using secret
     * @param token This is the token currently being processed
     * @return Claims This is all claims information in token
     */
    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

}
