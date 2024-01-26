package com.cloudapi.dto;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import com.cloudapi.model.Message;
import com.cloudapi.model.MessageUtilisateur;

import lombok.Data;

@Data
public class NewDiscussionDTO {
    private List<MessageUtilisateur> users;
    private String date_creation = Timestamp.valueOf(LocalDateTime.now()).toString();
    private List<Message> messages;
}
