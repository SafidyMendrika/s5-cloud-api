package com.cloudapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "marques")
public class Marque {
    @Id
    @Column(name = "id_marque")
    private int id;
    @Column(name = "nom_marque")
    private String nom;
    @Column(name="etat_marque")
    private int etat;
    

    

}
