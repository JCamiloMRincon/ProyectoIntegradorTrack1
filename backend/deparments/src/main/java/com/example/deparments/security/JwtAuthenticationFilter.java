package com.example.deparments.security;

import com.example.deparments.entities.User;
import com.example.deparments.repositories.IUserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private IUserRepository userRepository;

    public JwtAuthenticationFilter(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {
        AuthCredentials authCredentials = new AuthCredentials();

        try {
            authCredentials = new ObjectMapper().readValue(request.getReader(), AuthCredentials.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        User user = userRepository.findByEmail( authCredentials.getEmail() ).get();

        UsernamePasswordAuthenticationToken usernamePAT = new UsernamePasswordAuthenticationToken(
                authCredentials.getEmail(),
                authCredentials.getContrasenia(),
                Collections.singletonList( new SimpleGrantedAuthority(user.getRol().getNombre()) )
        );

        return getAuthenticationManager().authenticate(usernamePAT);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {

        UserDetailsImp userDetails = (UserDetailsImp) authResult.getPrincipal();
        String token = TokenUtils.createToken(userDetails.getFullName(), userDetails.getUsername());
        AuthResponse authResponse = new AuthResponse(token);
        String authResponseToString = new Gson().toJson(authResponse);

        response.addHeader("Authorization", "Bearer " + token);
        response.setContentType("application/json");
        response.getWriter().write(authResponseToString);
        response.getWriter().flush();

        super.successfulAuthentication(request, response, chain, authResult);
    }

}
