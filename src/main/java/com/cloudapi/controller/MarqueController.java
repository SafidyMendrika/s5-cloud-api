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
import org.springframework.web.multipart.MultipartFile;

import com.cloudapi.dto.MarqueDTO;
import com.cloudapi.json.Response;
import com.cloudapi.model.Marque;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@RestController
@RequestMapping("/api/marques")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MarqueController {
    @PersistenceContext
    private EntityManager entityManager;


    @GetMapping(value = "{id}/modeles")
    public ResponseEntity<Response> findAllModeles(@PathVariable int id){
        Response response = new Response();
        response.success("Liste des modèles de la marque "+id, new Marque().findById(entityManager, id).getModeles());
        return ResponseEntity.ok(response);
    }


    @GetMapping
    public ResponseEntity<Response> findAll(){
        Response response = new Response();
        response.success("Liste des marques", new Marque().findAll(entityManager));
        return ResponseEntity.ok(response);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Response> insert(@RequestBody MultipartFile file, MarqueDTO marqueDTO){
        Response response = new Response();
        try {
            response.success("Insertion d'une marque", new Marque().insert(entityManager, marqueDTO, file));
        } catch (Exception e) {
            e.printStackTrace();
            // response.error(new Exception("Erreur lors de l'insertion de la marque"));
            response.error(e);
        }
        
        return ResponseEntity.ok(response);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping(value="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response>  modifier(@PathVariable int id, @RequestBody MarqueDTO marqueDTO){
        Response response = new Response();
        response.success("Modification d'une Marque", new Marque().update(entityManager,id, marqueDTO));
        return ResponseEntity.ok(response);
    }


    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(value="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response>  supprimer(@PathVariable int id){
        Response response = new Response();
        response.success("Suppression d'une Marque", new Marque().delete(entityManager,id));
        return ResponseEntity.ok(response);
    }       
}
