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
@Table(name = "voitures")
public class Voiture {
    @Id
    @Column(name = "id_voiture")
    private int id;

    @OneToOne
    @JoinColumn(name = "idcategorie", referencedColumnName= "id_categorie")
    private Categorie categorie;

    @OneToOne
    @JoinColumn(name = "idmodele", referencedColumnName = "id_modele")
    private Modele modele;

    @Column(name = "nom_voiture")
    private String nom;

    @Column(name = "etat_voiture")
    private int etat;
}
