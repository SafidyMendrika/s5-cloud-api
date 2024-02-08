package com.cloudapi.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloudapi.dto.UtilisateurDTO;
import com.cloudapi.json.Response;
import com.cloudapi.service.AuthenticationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    
    private final AuthenticationService service;


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, value = "login-admin")
    public ResponseEntity<Response> authenticateAdmin(@RequestBody UtilisateurDTO utilisateurDTO){
        Response rep = new Response();
        try {
            rep.success("Authentification admin réussie",service.authenticateAdmin(utilisateurDTO));
        } catch (Exception e) {
            e.printStackTrace();
            rep.error(new Exception("Email ou mot de passe incorrect"));
        }
        return ResponseEntity.ok(rep);
    }


    @GetMapping("/token-admin")
    public ResponseEntity<Response> tokenAdmin(){
        Response rep = new Response();
        
        rep.success("Authentification admin réussie", service.getTokenAdmin());
        return ResponseEntity.ok(rep);
    }

    @GetMapping("/token-user")
    public ResponseEntity<Response> tokenUser(){
        Response rep = new Response();
        
        rep.success("Authentification user réussie", service.getTokenUser());
        return ResponseEntity.ok(rep);
    }

}
