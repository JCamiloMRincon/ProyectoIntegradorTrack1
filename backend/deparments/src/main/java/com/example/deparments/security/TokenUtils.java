package com.example.deparments.security;

import com.example.deparments.entities.User;
import com.example.deparments.repositories.IUserRepository;
import io.jsonwebtoken.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.*;

public class TokenUtils {

    private IUserRepository userRepository;
    private final static String ACCESS_TOKEN_SECRET = "secret";
    private final static Long ACCESS_TOKEN_VALIDITY_SECONDS = 2_592_000L;

    public TokenUtils(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static String createToken(String name, String email) {
        long expirationTime = ACCESS_TOKEN_VALIDITY_SECONDS * 1000;
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);

        Map<String, Object> extra = new HashMap<>();
        extra.put("name", name);

        return Jwts.builder()
                .setSubject(email)
                .setExpiration(expirationDate)
                .addClaims(extra)
                .signWith(SignatureAlgorithm.HS256, ACCESS_TOKEN_SECRET)
                .compact();
    }

    public UsernamePasswordAuthenticationToken getAuthentication(String token) {
        try {
            Claims claims = Jwts.parser()
                                .setSigningKey(ACCESS_TOKEN_SECRET)
                                .parseClaimsJws(token)
                                .getBody();

            String email = claims.getSubject();

            User user = userRepository.findByEmail(email).get();

            return new UsernamePasswordAuthenticationToken(email,
                                                           user.getContrasenia(),
                                                           Collections.singletonList( new SimpleGrantedAuthority(user.getRol().getNombre()) )
            );
        }
        catch(JwtException e) {
            return null;
        }
    }

}
