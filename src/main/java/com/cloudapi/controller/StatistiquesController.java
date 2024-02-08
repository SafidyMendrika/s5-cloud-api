package com.cloudapi.controller;


import org.hibernate.JDBCException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cloudapi.json.Response;
import com.cloudapi.model.Moteur;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@RestController
@RequestMapping("/api/statistiques")
public class StatistiquesController {
    @PersistenceContext
    private EntityManager entityManager;


    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> findAll(){
        Response response = new Response();
        try {
            response.success("Statistiques du plateforme", new Moteur().findAll(entityManager));
            
        }catch(JDBCException jdbce){
            response.error(new Exception("Erreur lors de l'insertino"));
        }
         catch (Exception e) {
            response.error(e);
            // TODO: handle exception
        }
        return ResponseEntity.ok(response);
    }

}
