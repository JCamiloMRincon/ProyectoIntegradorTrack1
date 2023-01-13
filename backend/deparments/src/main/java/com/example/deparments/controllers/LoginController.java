package com.example.deparments.controllers;

import com.example.deparments.security.AuthCredentials;
import com.example.deparments.security.AuthResponse;
import com.example.deparments.security.TokenUtils;
import com.example.deparments.security.UserDetailsImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsService userDetailsService;
    private TokenUtils jwtUtil;

    @PostMapping
    public ResponseEntity<AuthResponse> createAuthenticationToken(@RequestBody AuthCredentials authCredentials) throws Exception{

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authCredentials.getEmail(), authCredentials.getContrasenia()));
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect", e);
        }

        UserDetailsImp userDetails = (UserDetailsImp) userDetailsService.loadUserByUsername(authCredentials.getEmail());
        final String jwt = jwtUtil.createToken(userDetails.getFullName(), authCredentials.getEmail());

        return ResponseEntity.ok(new AuthResponse((jwt)));
    }

}
