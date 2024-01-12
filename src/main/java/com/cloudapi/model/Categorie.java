package com.cloudapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "categories")
public class Categorie {
    @Id
    @Column(name = "id_categorie")
    private int id;

    @Column(name = "nom_categorie")
    private String nom;

    @Column(name = "etat_categorie")
    private int etat;

 
}
