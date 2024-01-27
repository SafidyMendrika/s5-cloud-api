package com.cloudapi.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
@EnableMethodSecurity
@EnableWebSecurity
public class SecurityConfiguration {
    

    private static String[] WHITE_LIST_GET = {
        "api/annonces",
        "api/categories",
        "api/marques",
        "api/modeles",
        "api/test/**",
        "api/utilisateurs"
    };

    private static String[] WHITE_LIST_POST = {
        "api/utilisateurs",
        "api/utilisateurs/login",
        "api/test/**",
        "api/auth/**",

        "api/discussions",
        "api/discussions/message",

    };

    private static String[] WHITE_LIST_PUT = {
        "api/discussions"
    };
    private static String[] WHITE_LIST_DELETE = {
        "api/discussions",
        "api/discussions/*"
    };

    private final JwtAuthentificationFilter jwtAuthFilter;

    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

                http
            .csrf(csrf -> csrf
                    .disable())
            .authorizeHttpRequests(requests -> requests
                    .requestMatchers(HttpMethod.GET,WHITE_LIST_GET)
                    .permitAll()
                    .requestMatchers(HttpMethod.POST,WHITE_LIST_POST)
                    .permitAll()
                    .requestMatchers(HttpMethod.PUT,WHITE_LIST_PUT)
                    .permitAll()
                    .requestMatchers(HttpMethod.DELETE,WHITE_LIST_DELETE)
                    .permitAll()
                    .anyRequest()
                    .authenticated())
            .sessionManagement(management -> management
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authenticationProvider(authenticationProvider)
            .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    
}
