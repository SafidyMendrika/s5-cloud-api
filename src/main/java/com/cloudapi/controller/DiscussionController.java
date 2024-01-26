package com.cloudapi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cloudapi.dto.NewDiscussionDTO;
import com.cloudapi.dto.NewMessageDTO;
import com.cloudapi.json.Response;
import com.cloudapi.model.Message;
import com.cloudapi.service.DiscussionService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.websocket.server.PathParam;

@Service
@RestController
@RequestMapping("/api/discussions")
public class DiscussionController {

    @Autowired
    private DiscussionService discussionService;
    
    @PersistenceContext
    private EntityManager entityManager;

    // ALL DISCUSSIONS
     
    @GetMapping
    public ResponseEntity<Response> findAll(){
        Response rep = new Response();
        rep.success("Toutes les messages", discussionService.findAll());
        return ResponseEntity.ok(rep);
    }

    @GetMapping(path = "/utilisateurs/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> findDiscussionsOf(@PathVariable("id") int id){
        Response rep = new Response();
        rep.success("Messages de "+id, discussionService.findDuscissionsOf(id));
        return ResponseEntity.ok(rep);
    }
    
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> insert(@RequestBody NewDiscussionDTO newDiscussionDTO){
        Response rep = new Response();
        rep.success("creation discussion", discussionService.createNewDiscussion(newDiscussionDTO));
        return ResponseEntity.ok(rep);
    }
    @PostMapping(path ="/message",consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> addMessage(@RequestBody NewMessageDTO newMessageDTO){
        Response rep = new Response();  
        rep.success("creation discussion", discussionService.sendMessage(entityManager,newMessageDTO));
        return ResponseEntity.ok(rep);
    }

    @DeleteMapping(path ="/{id}",consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> close(@PathVariable("id") String id){
        Response rep = new Response();  
        rep.success("creation discussion", discussionService.closeDiscussion(entityManager,id));
        return ResponseEntity.ok(rep);
    }
}
