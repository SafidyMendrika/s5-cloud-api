package com.cloudapi.service;

import java.time.LocalDate;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cloudapi.dto.UtilisateurDTO;
import com.cloudapi.model.Utilisateur;
import com.cloudapi.repository.UtilisateurRepository;
import com.cloudapi.security.AuthenticationResponse;
import com.cloudapi.security.JwtService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UtilisateurRepository repository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;


    public Utilisateur update(int id, UtilisateurDTO utilisateurDTO) {
        var user = Utilisateur.builder()
            .id(id)
            .nom(utilisateurDTO.getNom())
            .email(utilisateurDTO.getEmail())
            .password(passwordEncoder.encode(utilisateurDTO.getMdp()))
            .date(LocalDate.parse(utilisateurDTO.getDate()))
            .genre(utilisateurDTO.getGenre())
            .telephone(utilisateurDTO.getTelephone())
            .build();
        return repository.save(user);
    }

    public AuthenticationResponse registerUser(UtilisateurDTO utilisateurDTO) {
        var user = Utilisateur.builder()
            .nom(utilisateurDTO.getNom())
            .email(utilisateurDTO.getEmail())
            .password(passwordEncoder.encode(utilisateurDTO.getMdp()))
            .date(LocalDate.parse(utilisateurDTO.getDate()))
            .genre(utilisateurDTO.getGenre())
            .telephone(utilisateurDTO.getTelephone())
            .build();
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
            .token(jwtToken)    
            .build();
    }


    public AuthenticationResponse authenticateAdmin(UtilisateurDTO utilisateurDTO)throws Exception {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(utilisateurDTO.getEmail(), utilisateurDTO.getMdp())
        );
        var user = repository.findByEmail(utilisateurDTO.getEmail())
                    .orElseThrow();
        if (user.getRole().equalsIgnoreCase("User")) throw new Exception("invalide");
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
            .token(jwtToken)    
            .build();
    }


    public AuthenticationResponse authenticateUser(UtilisateurDTO utilisateurDTO)throws Exception {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(utilisateurDTO.getEmail(), utilisateurDTO.getMdp())
        );
        var user = repository.findByEmail(utilisateurDTO.getEmail())
                    .orElseThrow();
        if (user.getRole().equalsIgnoreCase("admin")) throw new Exception("invalide");
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
            .token(jwtToken)    
            .build();
    }


    public AuthenticationResponse getTokenAdmin() {
        UtilisateurDTO utilisateurDTO = new UtilisateurDTO();
        utilisateurDTO.setEmail("root@email.com");
        utilisateurDTO.setMdp("root");
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

    public AuthenticationResponse getTokenUser() {
        UtilisateurDTO utilisateurDTO = new UtilisateurDTO();
        utilisateurDTO.setEmail("root@email.com");
        utilisateurDTO.setMdp("root");
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
