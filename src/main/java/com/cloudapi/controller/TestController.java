package com.cloudapi.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@RestController
@RequestMapping("/api/test")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TestController {
    

    @PersistenceContext
    private EntityManager entityManager;


    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<String> test(){
        return ResponseEntity.ok("Hello Admin");
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping("/test-user")
    public ResponseEntity<String> testUser(){
        return ResponseEntity.ok("Hello User");
    }


}
