package com.cloudapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cloudapi.json.Response;
import com.cloudapi.model.ClassementAnnonce;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@RestController
@RequestMapping("/api/classements")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClassementController {
    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping(path = "/annonces")
    public ResponseEntity<Response> classementAnnonce(@RequestParam int top){
        Response response = new Response();

        response.success("Top annonces", new ClassementAnnonce().findTop(entityManager,top));
        return ResponseEntity.ok(response);
    }
}
