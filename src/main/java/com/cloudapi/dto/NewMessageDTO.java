package com.cloudapi.dto;

import lombok.Data;

/**
 * NewMessageDTO
 */
@Data
public class NewMessageDTO {
    String id_discussion;
    int id_user;
    String content;
    
}