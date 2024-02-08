package com.cloudapi.dto;

import lombok.Data;

@Data
public class UtilisateurDTO {
    private String nom;
    private String email;
    private String telephone;
    private String date;
    private int genre;
    private String mdp;
    private int role = 0;
}
