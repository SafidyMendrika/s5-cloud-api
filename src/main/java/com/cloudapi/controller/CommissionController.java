package com.cloudapi.controller;


import org.hibernate.JDBCException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloudapi.dto.CommissionDTO;
import com.cloudapi.json.Response;
import com.cloudapi.model.Commission;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@RestController
@RequestMapping("/api/commissions")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CommissionController {
    @PersistenceContext
    private EntityManager entityManager;


    @GetMapping(value = "/history")
    public ResponseEntity<Response> findAll(){
        Response response = new Response();
        try {
            response.success("Liste des Commissions", new Commission().findAll(entityManager));
            
        }catch(JDBCException jdbce){
            response.error(new Exception("Erreur lors de l'affichage des commissions"));
        }
         catch (Exception e) {
            response.error(e);
            // TODO: handle exception
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Response> find(){
        Response response = new Response();
        try {
            response.success("Commission Actuel", new Commission().find(entityManager));
            
        }catch(JDBCException jdbce){
            response.error(new Exception("Erreur lors de l'affichage du commission actuel"));
        }
         catch (Exception e) {
            response.error(e);
            // TODO: handle exception
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> insert(@RequestBody CommissionDTO CommissionDTO){
        Response response = new Response();
        try {
            response.success("Insertion d'un Commission", new Commission().insert(entityManager, CommissionDTO));
            
        }catch(JDBCException jdbce){
            response.error(new Exception("erreur d'insertion"));
        } catch (Exception e) {
            response.error(e);
            // TODO: handle exception
        }
        return ResponseEntity.ok(response);
    }


    @PutMapping( consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response>  modifier(@PathVariable int id, @RequestBody CommissionDTO CommissionDTO){
        Response response = new Response();
        response.success("Modification d'un Commission", new Commission().insert(entityManager, CommissionDTO));
        return ResponseEntity.ok(response);
    }
 
}
