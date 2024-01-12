package com.cloudapi.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloudapi.dto.ModeleDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@RestController
@RequestMapping("/modeles")
public class ModeleController {
    @PersistenceContext
    private EntityManager entityManager;


    @GetMapping
    public ResponseEntity<String> findAll(){
        return ResponseEntity.ok("sessions all");
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String insert(@RequestBody ModeleDTO modeleDTO){
        return "insertion";
    }


    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String modifier(@RequestBody ModeleDTO modeleDTO){
        return "modification";
    }

    @DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String supprimer(@RequestBody ModeleDTO modeleDTO){
        return "supprimer";
    } 
}
