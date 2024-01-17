package com.cloudapi.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "messages")
public class Message {
    @Id
    private String id;
    private int idutilisateur1;
    private int idutilisateur2;
    private int envoyeur;
    private String message;
    private LocalDateTime date;
}
