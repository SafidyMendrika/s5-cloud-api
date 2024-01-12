package com.cloudapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "modeles")
public class Modele {
    @Id
    @Column(name = "id_modele")
    private int id;

    @OneToOne
    @JoinColumn(name = "idmarque", referencedColumnName = "id_marque")
    private Marque idMarque;

    @Column(name = "nom_modele")
    private String nom;

    @Column(name = "etat_modele")
    private int etat;


    
}
