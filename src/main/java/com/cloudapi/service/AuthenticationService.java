package com.cloudapi.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cloudapi.model.Utilisateur;
import com.cloudapi.repository.UtilisateurRepository;
import com.cloudapi.security.AuthenticationRequest;
import com.cloudapi.security.AuthenticationResponse;
import com.cloudapi.security.JwtService;
import com.cloudapi.security.RegisterRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UtilisateurRepository repository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = Utilisateur.builder()
            .nom(request.getNom())
            .email(request.getEmail())
            .password(passwordEncoder.encode(request.getMdp()))
            .role(0)
            .build();
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
            .token(jwtToken)    
            .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getEmail(), request.getMdp())
        );
        var user = repository.findByEmail(request.getEmail())
                    .orElseThrow();
                    var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
            .token(jwtToken)    
            .build();
    }
        
}
