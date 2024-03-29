package com.cloudapi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cloudapi.json.Response;
import com.cloudapi.service.MessageService;

@Service
@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping
    public ResponseEntity<Response> getMessages(@RequestParam("iduser1") int id1, @RequestParam("iduser2") int id2){
        Response rep = new Response();
        rep.success("Messages reçus", messageService.findBetweenUsers(id1, id2));
        return ResponseEntity.ok(rep);
    }
    
}
