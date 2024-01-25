package com.cloudapi.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloudapi.dto.UtilisateurDTO;
import com.cloudapi.json.Response;
import com.cloudapi.model.Utilisateur;
import com.cloudapi.service.AuthenticationService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/utilisateurs")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class UtilisateurController {
    @PersistenceContext
    private EntityManager entityManager;

    private final AuthenticationService service;

    @GetMapping(value = "{id}/annonces-favorites")
    public ResponseEntity<Response> findAllAnnoncesFavorites(@PathVariable int id){
        Response response = new Response();
        response.success("Liste des annonces favorites de l' utilisateur "+ id, new Utilisateur().findById(entityManager,id).getAnnonceFavorites());
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "{id}/annonces")
    public ResponseEntity<Response> findAllAnnonces(@PathVariable int id){
        Response response = new Response();
        response.success("Liste des annonces de l' utilisateur "+ id, new Utilisateur().findById(entityManager,id).getAnnonces());
        return ResponseEntity.ok(response);
    }

    // @PostMapping(value = "inscription", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    // public ResponseEntity<Response> inscription(@RequestBody UtilisateurDTO utilisateurDTO){
    //     Response response = new Response();
    //     response.success("Inscription d'un utilisateur", service.register(utilisateurDTO));
    //     return ResponseEntity.ok(response);
    // }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, value = "login")
    public ResponseEntity<Response> login(@RequestBody UtilisateurDTO utilisateurDTO){
        Response rep = new Response();
        try {
            rep.success("Login d'un utilisateur", service.authenticate(utilisateurDTO));
            return ResponseEntity.ok(rep);
        } catch (Exception e) {
            rep.error(new Exception("Email ou mot de passe incorrect"));
        }
        return ResponseEntity.ok(rep);
       
    }


    @GetMapping
    public ResponseEntity<Response> findAll(){
        Response response = new Response();
        response.success("Liste des utilisateurs", new Utilisateur().findAll(entityManager));
        return ResponseEntity.ok(response);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> insert(@RequestBody UtilisateurDTO utilisateurDTO){
        Response response = new Response();
        try {
            response.success("Inscription d'un utilisateur", service.register(utilisateurDTO));
        } catch (Exception e) {
            response.error(new Exception("Erreur lors de l'insertion d'un utilisateur"));
        }
        return ResponseEntity.ok(response);
    }

    @PutMapping(value="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response>  modifier(@PathVariable int id, @RequestBody UtilisateurDTO utilisateurDTO){
        Response response = new Response();
        response.success("Modification d'un utilisateur", new Utilisateur().update(entityManager,id, utilisateurDTO));
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response>  supprimer(@PathVariable int id){
        Response response = new Response();
        response.success("Suppression d'un utilisateur", new Utilisateur().delete(entityManager,id));
        return ResponseEntity.ok(response);
    }   
}
