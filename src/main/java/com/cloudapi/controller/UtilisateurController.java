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

import com.cloudapi.dto.UtilisateurDTO;
import com.cloudapi.json.Response;
import com.cloudapi.model.Utilisateur;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {
    @PersistenceContext
    private EntityManager entityManager;


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, value = "login")
    public ResponseEntity<Object> login(@RequestBody UtilisateurDTO utilisateurDTO){
        Response rep = new Response();
        try {
            rep = new Utilisateur().verificationLogin(entityManager, utilisateurDTO.getEmail(), utilisateurDTO.getMdp());
            return ResponseEntity.ok(rep);
        } catch (Exception e) {
            rep.error(e);
        }
        return ResponseEntity.ok(rep);
       
    }


    @GetMapping
    public ResponseEntity<String> findAll(){
        return ResponseEntity.ok("utilisateurs all");
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String insert(@RequestBody UtilisateurDTO utilisateurDTO){
        return "insertion";
    }


    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String modifier(@RequestBody UtilisateurDTO utilisateurDTO){
        return "modification";
    }

    @DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String supprimer(@RequestBody UtilisateurDTO utilisateurDTO){
        return "supprimer";
    }
}
