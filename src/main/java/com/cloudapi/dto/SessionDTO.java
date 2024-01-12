package com.cloudapi.dto;

import lombok.Data;

@Data
public class SessionDTO {
    private int id;
    private int idutilisateur;
    private int code;
    private String token;
}
