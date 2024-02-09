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

import com.cloudapi.dto.AnnonceDTO;
import com.cloudapi.dto.AnnonceFavoriteDTO;
import com.cloudapi.dto.UtilisateurDTO;
import com.cloudapi.json.Response;
import com.cloudapi.model.AnnonceFavorite;
import com.cloudapi.model.Utilisateur;
import com.cloudapi.repository.UtilisateurRepository;
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


    private final UtilisateurRepository utilisateurRepository;


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE,value = "/de-fav")
    public ResponseEntity<Response> DisLike(@RequestBody AnnonceFavoriteDTO annonceFavoriteDTO){
        Response response = new Response();
        try {
            response.success("Dislike d'une annonce", AnnonceFavorite.delete(entityManager, annonceFavoriteDTO));
        } catch (Exception e) {
            e.printStackTrace();
            response.error(new Exception("Erreur lors du dislike d'une annonce"));
        }
        return ResponseEntity.ok(response);
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE,value = "/fav")
    public ResponseEntity<Response> ILike(@RequestBody AnnonceFavoriteDTO annonceFavoriteDTO){
        Response response = new Response();
        try {
            response.success("Like d'une annonce", AnnonceFavorite.insert(entityManager, annonceFavoriteDTO));
        } catch (Exception e) {
            e.printStackTrace();
            response.error(new Exception("Erreur lors du Like d'une annonce"));
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "{id}/annonces-favorites")
    public ResponseEntity<Response> findAllAnnoncesFavorites(@PathVariable int id){
        Response response = new Response();
        response.success("Liste des annonces favorites de l' utilisateur "+ id, Utilisateur.findById(entityManager,id).getAnnonceFavorites());
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "{id}/annonces")
    public ResponseEntity<Response> findAllAnnonces(@PathVariable int id){
        Response response = new Response();
        response.success("Liste des annonces de l' utilisateur "+ id, Utilisateur.findById(entityManager,id).getAnnonces());
        return ResponseEntity.ok(response);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, value = "login")
    public ResponseEntity<Response> login(@RequestBody UtilisateurDTO utilisateurDTO){
        Response rep = new Response();
        try {
            rep.success("Login d'un utilisateur", service.authenticateUser(utilisateurDTO));
            return ResponseEntity.ok(rep);
        } catch (Exception e) {
            e.printStackTrace();
            rep.error(new Exception("Email ou mot de passe incorrect"));
        }
        return ResponseEntity.ok(rep);
       
    }


    @GetMapping(value ="{id}" )
    public ResponseEntity<Response> findById(@PathVariable int id){
        Response response = new Response();
        response.success("Utilisateur "+ id, utilisateurRepository.findById(id));
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Response> findAll(){
        Response response = new Response();
        response.success("Liste des utilisateurs", new Utilisateur().findAll(entityManager));
        return ResponseEntity.ok(response);
    }



    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> inscription(@RequestBody UtilisateurDTO utilisateurDTO){
        Response response = new Response();
        try {
            response.success("Inscription d'un utilisateur", service.registerUser(utilisateurDTO));
        } catch (Exception e) {
            e.printStackTrace();
            response.error(new Exception("Erreur lors de l'insertion d'un utilisateur"));
        }
        return ResponseEntity.ok(response);
    }

    @PutMapping(value="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response>  modifier(@PathVariable int id, @RequestBody UtilisateurDTO utilisateurDTO){
        Response response = new Response();
        response.success("Modification d'un utilisateur", service.update(id, utilisateurDTO));
        return ResponseEntity.ok(response);
    }


    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(value="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response>  supprimer(@PathVariable int id){
        Response response = new Response();
        response.success("Suppression d'un utilisateur", new Utilisateur().delete(entityManager,id));
        return ResponseEntity.ok(response);
    }   

    @GetMapping(path = "/nombres")
    public ResponseEntity<Response> countUsers(){
        Response response = new Response();
        response.success("nombre des utilisateurs", Utilisateur.findNombreUtilisateur(entityManager));
        return ResponseEntity.ok(response);
    }
}
