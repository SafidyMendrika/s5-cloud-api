package com.cloudapi.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloudapi.dto.MarqueDTO;
import com.cloudapi.json.Response;
import com.cloudapi.model.Marque;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@RestController
@RequestMapping("/marques")
public class MarqueController {
    @PersistenceContext
    private EntityManager entityManager;


    @GetMapping
    public ResponseEntity<Response> findAll(){
        Response response = new Response();
        response.success("Liste des marques", new Marque().findAll(entityManager));
        return ResponseEntity.ok(response);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> insert(@RequestBody MarqueDTO marqueDTO){
        Response response = new Response();
        response.success("Insertion d'une marque", new Marque().insert(entityManager, marqueDTO));
        return ResponseEntity.ok(response);
    }


    @PutMapping(value="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response>  modifier(@PathVariable int id, @RequestBody MarqueDTO marqueDTO){
        Response response = new Response();
        response.success("Modification d'une Marque", new Marque().update(entityManager,id, marqueDTO));
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response>  supprimer(@PathVariable int id){
        Response response = new Response();
        response.success("Suppression d'une Marque", new Marque().delete(entityManager,id));
        return ResponseEntity.ok(response);
    }       
}
