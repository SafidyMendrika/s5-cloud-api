package com.cloudapi.controller;

import java.sql.SQLException;

import org.hibernate.JDBCException;
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
import com.cloudapi.dto.MoteurDTO;
import com.cloudapi.json.Response;
import com.cloudapi.model.Marque;
import com.cloudapi.model.Moteur;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@RestController
@RequestMapping("/api/moteurs")
public class MoteurController {
    @PersistenceContext
    private EntityManager entityManager;


    @GetMapping
    public ResponseEntity<Response> findAll(){
        Response response = new Response();
        try {
            response.success("Liste des moteurs", new Moteur().findAll(entityManager));
            
        }catch(JDBCException jdbce){
            response.error(new Exception("Erreur lors de l'insertino"));
        }
         catch (Exception e) {
            response.error(e);
            // TODO: handle exception
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> insert(@RequestBody MoteurDTO moteurDTO){
        Response response = new Response();
        try {
            response.success("Insertion d'un moteur", new Moteur().insert(entityManager, moteurDTO));
            
        }catch(JDBCException jdbce){
            response.error(new Exception("erreur d'insertion"));
        } catch (Exception e) {
            response.error(e);
            // TODO: handle exception
        }
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
