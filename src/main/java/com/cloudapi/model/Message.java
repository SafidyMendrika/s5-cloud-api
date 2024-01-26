package com.cloudapi.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;


import lombok.Data;

@Data
public class Message {
    private MessageUtilisateur user;
    private String content;
    private String date_envoie = Timestamp.valueOf(LocalDateTime.now()).toString() ;
}
