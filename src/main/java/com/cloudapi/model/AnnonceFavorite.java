package com.cloudapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "annonces_favorites")
public class AnnonceFavorite {
    @Id
    @Column(name = "id_favori")
    private int id;


    @Column(name = "etat_favori")
    private int etat;

    @OneToOne
    @JoinColumn(name="idannonce", referencedColumnName = "id_annonce")
    private Annonce annonce;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name ="idutilisateur")
    private Utilisateur utilisateur;

}
