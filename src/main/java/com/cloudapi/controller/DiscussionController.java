package com.cloudapi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloudapi.dto.NewDiscussionDTO;
import com.cloudapi.dto.NewMessageDTO;
import com.cloudapi.json.Response;
import com.cloudapi.model.Discussion;
import com.cloudapi.model.Utilisateur;
import com.cloudapi.repository.DiscussionRepository;
import com.cloudapi.repository.UtilisateurRepository;
import com.cloudapi.service.DiscussionService;
import com.cloudapi.service.FirebaseMessagingService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
@RestController
@RequestMapping("/api/discussions")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DiscussionController {

    @Autowired
    private DiscussionService discussionService;
    
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private FirebaseMessagingService firebaseMessagingService;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    
    @Autowired
    private DiscussionRepository discussionRepository;
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
        try {
            rep.success("Messages de "+id, discussionService.findDuscissionsOf(id));
        } catch (Exception e) {
            e.printStackTrace();
            rep.error(new Exception("Erreur lors de la récupération du message"));
            // TODO: handle exception
        }
        return ResponseEntity.ok(rep);
    }
    
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> insert(@RequestBody NewDiscussionDTO newDiscussionDTO){
        Response rep = new Response();
        rep.success("creation discussion", discussionService.createNewDiscussion(newDiscussionDTO));

        try {
            
            Utilisateur u = utilisateurRepository.findById(newDiscussionDTO.getUsers().get(1).getId_utilisateur()).get();
            Utilisateur sender = utilisateurRepository.findById(newDiscussionDTO.getUsers().get(0).getId_utilisateur()).get();
            firebaseMessagingService.sendNotificationTo(u, "Info Gascar app", sender.getNom()+" vous a ouvert une discussion avec vous");
            
        } catch (Exception e) {
            // TODO: handle exception
        }
        return ResponseEntity.ok(rep);
    }

    @PostMapping(path ="/message",consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> addMessage(@RequestBody NewMessageDTO newMessageDTO){
        Response rep = new Response();  
        rep.success("creation discussion", discussionService.sendMessage(entityManager,newMessageDTO));
        
        try {
            
            Utilisateur u = utilisateurRepository.findById(newMessageDTO.getId_utilisateur()).get();
            
            Discussion chatDocument = discussionRepository.findById(newMessageDTO.getId_discussion()).get();
            
            int idSender = chatDocument.getUsers().get(0).getId_utilisateur();
            if (idSender == u.getId()) {
                idSender = chatDocument.getUsers().get(1).getId_utilisateur();
            }
            
            Utilisateur sender = utilisateurRepository.findById(idSender).get();
            
            firebaseMessagingService.sendNotificationTo(u, "Message de "+sender, newMessageDTO.getContent());
        } catch (Exception e) {
            // TODO: handle exception
        }
            return ResponseEntity.ok(rep);
        }
        
        @DeleteMapping(path ="/{id}",consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> close(@PathVariable("id") String id){
        Response rep = new Response();  
        rep.success("creation discussion", discussionService.closeDiscussion(entityManager,id));
        return ResponseEntity.ok(rep);
    }
}
