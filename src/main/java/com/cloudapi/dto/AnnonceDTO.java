package com.cloudapi.dto;

import lombok.Data;

@Data
public class AnnonceDTO {
    private int id;
    private int idutilisateur;
    private int idvoiture;
    private String description;
}
