package com.example.demo.security;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {
    private static final Logger LOG = LoggerFactory.getLogger(JwtUtils.class);
    @Value("${app.jwt.secret}")

    private String jwtSecret;

    public boolean validateJwtToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
        } catch(ExpiredJwtException e) {
            LOG.error("Token expirado {}",e.getMessage());
        } catch(SignatureException e) {
            LOG.error("Token expirado {}",e.getMessage());
        }
        return true;
    }
    public String getUserNameFromJwtToken(String token){
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

}
