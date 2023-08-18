package com.example.demo.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class JwtUtils {
    private static final Logger LOG= LoggerFactory.getLogger(JwtUtils.class);
    @Value("${app.jwt.secret}")

    private String jwtSecret;

public boolean validateJwtToken(String token){
    Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
    return true;

}

}
