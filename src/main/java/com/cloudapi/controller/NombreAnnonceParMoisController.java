package com.cloudapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cloudapi.json.Response;
import com.cloudapi.model.Marque;
import com.cloudapi.model.NombreAnnonceParMois;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@RestController
@RequestMapping("/api/statistiques")
public class NombreAnnonceParMoisController {
    
    @PersistenceContext
    private EntityManager entityManager;


}
