package com.cloudapi.service;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.cloudapi.dto.NewMessageDTO;

@Service
public class WSService {
    

    private final SimpMessagingTemplate messagingTemplate;

    public WSService(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public void notifyUser(final String id, final NewMessageDTO message) {

        // ResponseMessage response = new ResponseMessage(message.getcontent(), message.getSender()); 

        // respone = contenu
        // eto ndray ilay mi specifier hoe alefa any amin'iza ilay msg (id)
        // messagingTemplate.convertAndSendToUser(id, "/topic/private-messages", response);
    }
}
