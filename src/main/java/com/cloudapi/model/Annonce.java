package com.cloudapi.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "annonces")
public class Annonce {
    @Id
    @Column(name = "id_annonce")
    private int id;

    @Column(name = "idvoiture")
    private int idVoiture;

    @Column(name= "description_annonce")
    private String description;

    @Column(name = "date_validation")
    private LocalDateTime dateValidation;


    @Column(name = "date_annonce")
    private LocalDateTime dateAnnonce;

    @Column(name = "etat_annonce")
    private int etat;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name ="idutilisateur")
    private Utilisateur utilisateur;


    
}
