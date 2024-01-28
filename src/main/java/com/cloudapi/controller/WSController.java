package com.cloudapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cloudapi.dto.NewMessageDTO;
import com.cloudapi.service.WSService;


@RestController
public class WSController {
    
    
    @Autowired
    private WSService service;
    
    @PostMapping("/send-private-message")
    public void sendPrivateMessage(
            @RequestBody final NewMessageDTO message) {
        // service.notifyUser(message.getReceiver_id(), message);
    }
}
