package com.cloudapi.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloudapi.dto.CategorieDTO;
import com.cloudapi.model.Categorie;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@RestController
@RequestMapping("/test")
public class TestController {
    

    @PersistenceContext
    private EntityManager entityManager;


    @GetMapping("test")
    public ResponseEntity<Categorie> test(){
        ObjectMapper mapper = new ObjectMapper();
        CategorieDTO categorieDTO = new CategorieDTO();
        categorieDTO.setNom("4L2");
        return ResponseEntity.ok(new Categorie().delete(entityManager,7));
    }
}
