package com.cloudapi.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cloudapi.dto.UtilisateurDTO;
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

    public AuthenticationResponse register(UtilisateurDTO utilisateurDTO) {
        var user = Utilisateur.builder()
            .nom(utilisateurDTO.getNom())
            .email(utilisateurDTO.getEmail())
            .password(passwordEncoder.encode(utilisateurDTO.getMdp()))
            .role(0)
            .build();
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
            .token(jwtToken)    
            .build();
    }


    public AuthenticationResponse authenticate(UtilisateurDTO utilisateurDTO) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(utilisateurDTO.getEmail(), utilisateurDTO.getMdp())
        );
        var user = repository.findByEmail(utilisateurDTO.getEmail())
                    .orElseThrow();
                    var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
            .token(jwtToken)    
            .build();
    }
        
}
