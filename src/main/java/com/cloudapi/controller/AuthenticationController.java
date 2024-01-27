package com.cloudapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloudapi.dto.UtilisateurDTO;
import com.cloudapi.json.Response;
import com.cloudapi.security.AuthenticationRequest;
import com.cloudapi.security.RegisterRequest;
import com.cloudapi.service.AuthenticationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    
    private final AuthenticationService service;


    @PostMapping("/token")
    public ResponseEntity<Response> authenticate(){
        Response rep = new Response();
        rep.success("Authentification réussie", service.getToken());
        return ResponseEntity.ok(rep);
    }

}
