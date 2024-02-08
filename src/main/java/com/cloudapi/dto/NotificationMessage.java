package com.cloudapi.dto;

import java.util.HashMap;

import lombok.Data;

@Data
public class NotificationMessage {
    private String recipientToken;
    private String title;
    private String body;
    private String image;
    private HashMap<String,String> data = new HashMap<>();
}
