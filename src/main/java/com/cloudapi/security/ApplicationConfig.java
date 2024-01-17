package com.cloudapi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.cloudapi.repository.UtilisateurRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {
    
    private final UtilisateurRepository utilisateurRepository;

    @Bean
    public UserDetailsService userDetailsService(){
        return username -> utilisateurRepository.findByEmail(username)
            .orElseThrow(() -> new UsernameNotFoundException("Utilsateur not found"));
    }
}
