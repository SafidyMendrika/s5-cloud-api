package com.cloudapi.controller;

import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloudapi.json.Response;

@RestController
@RequestMapping("/messages")
public class MessageController {


    
    // @Autowired
    private MongoTemplate mongoTemplate;



    @GetMapping(value = "{id1}/{id2}")
    public ResponseEntity<Response> getMessages(@PathVariable int id1, @PathVariable int id2){
        Response rep = new Response();
        Query query = new Query(Criteria.where("idutilisateur1").in(id1,id2)
                                .and("idutilisateur2").in(id1,id2));
        rep.success("Messages reçus", mongoTemplate.find(query, Message.class));
        return ResponseEntity.ok(rep);
    }
    
}
