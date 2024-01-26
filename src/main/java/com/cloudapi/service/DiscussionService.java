package com.cloudapi.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudapi.dto.NewDiscussionDTO;
import com.cloudapi.dto.NewMessageDTO;
import com.cloudapi.model.Discussion;
import com.cloudapi.model.Message;
import com.cloudapi.model.MessageUtilisateur;
import com.cloudapi.model.Utilisateur;
import com.cloudapi.repository.DiscussionRepository;

import jakarta.persistence.EntityManager;


@Service
public class DiscussionService {
    
    
    @Autowired
    private DiscussionRepository discussionRepository;

    public List<Discussion> findAll(){
        return discussionRepository.findAll();
    }
    
    public List<Discussion> findDuscissionsOf(int id){
        return discussionRepository.findDiscussionByUserId(id);
    }

    public Discussion createNewDiscussion(NewDiscussionDTO newDiscussionDTO) {
        Discussion newChat = new Discussion();
        newChat.setUsers(newDiscussionDTO.getUsers());
        newChat.setDate_creation(newDiscussionDTO.getDate_creation());
        newChat.setMessages(newDiscussionDTO.getMessages());

        return discussionRepository.save(newChat);
    }

    public Discussion sendMessage(EntityManager entityManager,NewMessageDTO messageDTO) {
        Discussion chatDocument = discussionRepository.findById(messageDTO.getId_discussion())
                .orElseThrow(() -> new RuntimeException("Chat not found with id: " + messageDTO.getId_discussion()));

        Message message = new Message();
        message.setContent(messageDTO.getContent());

        MessageUtilisateur us = new MessageUtilisateur();
        us.setId_utilisateur(messageDTO.getId_user());
        // us = Utilisateur.findById(entityManager, messageDTO.getId_user()).toMessageUtilisateur();
        message.setUser(us);
        message.setDate_envoie(Timestamp.valueOf(LocalDateTime.now()).toString());
        

        List<Message> messages = chatDocument.getMessages();
        messages.add(message);

        return discussionRepository.save(chatDocument);
    }

    public Discussion closeDiscussion(EntityManager entityManager,String idDiscussion) {
        Discussion chatDocument = discussionRepository.findById(idDiscussion)
                .orElseThrow(() -> new RuntimeException("Chat not found with id: " + idDiscussion));

        chatDocument.setClosed(true);

        return discussionRepository.save(chatDocument);
    }
}
