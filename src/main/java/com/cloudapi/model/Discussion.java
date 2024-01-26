package com.cloudapi.model;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.Data;

import java.util.List;

@Data
@Document(collection = "discussions")
public class Discussion {
    @Id
    private String id;

    private List<MessageUtilisateur> users;

    private String date_creation;

    private List<Message> messages;

    private boolean closed = false;
    public void create(){
        
    }
}
