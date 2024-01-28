package com.cloudapi.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.cloudapi.dto.NewMessageDTO;
import com.cloudapi.json.Response;

@Controller
public class MessageController {
    
    @MessageMapping("/send")
    @SendTo("all/messages")
    public NewMessageDTO send(final NewMessageDTO message){
        return message;
    }
 
    @MessageMapping("/private")
    public NewMessageDTO sendToAspecificuser(final NewMessageDTO message){
        return message;
    }
}
