package com.cloudapi.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cloudapi.dto.ModeleDTO;
import com.cloudapi.json.Response;
import com.cloudapi.model.Modele;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@RestController
@RequestMapping("/api/modeles")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ModeleController {
    @PersistenceContext
    private EntityManager entityManager;


    @GetMapping
    public ResponseEntity<Response> findAll(){
        Response response = new Response();
        response.success("Liste des modèles", new Modele().findAll(entityManager));
        return ResponseEntity.ok(response);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> insert(@RequestBody ModeleDTO modeleDTO){
        Response response = new Response();
        response.success("Insertion d'un modèle", new Modele().insert(entityManager, modeleDTO));
        return ResponseEntity.ok(response);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping(value="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response>  modifier(@PathVariable int id, @RequestBody ModeleDTO modeleDTO){
        Response response = new Response();
        response.success("Modification d'une Modele", new Modele().update(entityManager,id, modeleDTO));
        return ResponseEntity.ok(response);
    }


    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(value="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response>  supprimer(@PathVariable int id){
        Response response = new Response();
        response.success("Suppression d'une Modele", new Modele().delete(entityManager,id));
        return ResponseEntity.ok(response);
    }   
}
