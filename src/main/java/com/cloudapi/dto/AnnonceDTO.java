package com.cloudapi.dto;

import lombok.Data;

@Data
public class AnnonceDTO {
    private int id;
    private int idutilisateur;
    private int idmodele;
    private String description;
    private double prix;
    private int idenergie;
    private int idmoteur;
    private int idvitesse;
    private String date;
}
