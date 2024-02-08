package com.cloudapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloudapi.json.Response;
import com.cloudapi.model.Benefice;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@RestController
@RequestMapping("/api/benefices")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BeneficeController {
    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping
    public ResponseEntity<Response> find(/*@RequestParam String dateA,@RequestParam String dateB*/){
        Response response = new Response();
        // Date date1 = null;
        // Date date2 = null;

        // try {
        //     date1 = Date.valueOf(dateA);
        //     date2 = Date.valueOf(dateB);
        // } catch (Exception e) {
        //     response.error(new Exception("Date invalide"));
        //     return ResponseEntity.ok(response);
        // }

        // response.success("Benefices ", new Benefice().getRealBenefice(entityManager,date1,date2));
        response.success("Benefices ", new Benefice().getRealBenefice(entityManager));
        return ResponseEntity.ok(response);
    }
}
