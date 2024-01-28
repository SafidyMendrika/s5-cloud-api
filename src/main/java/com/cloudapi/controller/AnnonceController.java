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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cloudapi.dto.AnnonceDTO;
import com.cloudapi.json.Response;
import com.cloudapi.model.Annonce;
import com.cloudapi.model.NombreAnnonceParMois;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@RestController
@RequestMapping("/api/annonces")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AnnonceController {
    @PersistenceContext
    private EntityManager entityManager;


    @GetMapping(value = "{id}/photos")
    public ResponseEntity<Response> findAllPhotos(@PathVariable int id){
        Response response = new Response();
        response.success("Liste des photos de l'annonce N°" + id, new Annonce().findById(entityManager, id).getPhotoAnnonces());
        return ResponseEntity.ok(response);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping(value="/{id}/confirmer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> confirmer(@PathVariable int id){
        Response response = new Response();
        response.success("Confirmer d'une annonce", new Annonce().confirmer(entityManager,id));
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Response> findAll(){
        Response response = new Response();
        response.success("Liste des annonces", new Annonce().findAll(entityManager));
        return ResponseEntity.ok(response);
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> insert(@RequestBody AnnonceDTO annonceDTO){
        Response response = new Response();
        response.success("Insertion d'une annonce", new Annonce().insert(entityManager, annonceDTO));
        return ResponseEntity.ok(response);
    }


    @PutMapping(value="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response>  modifier(@PathVariable int id, @RequestBody AnnonceDTO annonceDTO){
        Response response = new Response();
        response.success("Modification d'une annonce", new Annonce().update(entityManager,id, annonceDTO));
        return ResponseEntity.ok(response);
    }


    @DeleteMapping(value="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response>  supprimer(@PathVariable int id){
        Response response = new Response();
        response.success("Suppression d'une annonce", new Annonce().delete(entityManager,id));
        return ResponseEntity.ok(response);
    }     

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/statistiques")
    public ResponseEntity<Response> findSat(@RequestParam int annee)throws Exception{
        Response response = new Response();
        response.success("Liste des benefices de l'année' "+annee, new NombreAnnonceParMois().findAByYear(entityManager, annee));
        return ResponseEntity.ok(response);
    }
}
