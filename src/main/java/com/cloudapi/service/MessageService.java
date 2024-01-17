package com.cloudapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudapi.model.Message;
import com.cloudapi.repository.MessageRepository;


@Service
public class MessageService {
    
    
    @Autowired
    private MessageRepository messageRepository;



    public List<Message> findAll(){
        return messageRepository.findAll();
    }

    public List<Message> findBetweenUsers(int user1, int user2){
        return messageRepository.findMessagesBetweenUsers(user1, user2);
    }
}
