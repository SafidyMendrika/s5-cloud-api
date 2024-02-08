package com.cloudapi.controller;


import org.hibernate.JDBCException;
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

import com.cloudapi.dto.VitesseDTO;
import com.cloudapi.json.Response;
import com.cloudapi.model.Vitesse;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@RestController
@RequestMapping("/api/vitesses")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class VitesseController {
    @PersistenceContext
    private EntityManager entityManager;


    @GetMapping
    public ResponseEntity<Response> findAll(){
        Response response = new Response();
        try {
            response.success("Liste des Vitesses", new Vitesse().findAll(entityManager));
            
        }catch(JDBCException jdbce){
            response.error(new Exception("Erreur lors de l'insertino"));
        }
         catch (Exception e) {
            response.error(e);
            // TODO: handle exception
        }
        return ResponseEntity.ok(response);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> insert(@RequestBody VitesseDTO VitesseDTO){
        Response response = new Response();
        try {
            response.success("Insertion d'un Vitesse", new Vitesse().insert(entityManager, VitesseDTO));
            
        }catch(JDBCException jdbce){
            response.error(new Exception("erreur d'insertion"));
        } catch (Exception e) {
            response.error(e);
            // TODO: handle exception
        }
        return ResponseEntity.ok(response);
    }



    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping(value="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response>  modifier(@PathVariable int id, @RequestBody VitesseDTO VitesseDTO){
        Response response = new Response();
        response.success("Modification d'un Vitesse", new Vitesse().update(entityManager,id, VitesseDTO));
        return ResponseEntity.ok(response);
    }


    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(value="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response>  supprimer(@PathVariable int id){
        Response response = new Response();
        response.success("Suppression d'un Vitesse", new Vitesse().delete(entityManager,id));
        return ResponseEntity.ok(response);
    }       
}
