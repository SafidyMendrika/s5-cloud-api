package com.cloudapi.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
public class Message {
    private MessageUtilisateur user;
    private String content;
    private String date_envoie = Timestamp.valueOf(LocalDateTime.now()).toString() ;
}
