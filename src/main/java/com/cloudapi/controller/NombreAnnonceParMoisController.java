package com.cloudapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@RestController
@RequestMapping("/api/statistiques")
public class NombreAnnonceParMoisController {
    
    @PersistenceContext
    private EntityManager entityManager;


}
