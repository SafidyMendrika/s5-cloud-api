package com.cloudapi.model;


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
@Table(name = "photos_annonces")
public class PhotoAnnonce {

    @Id
    @Column(name = "id_photo")
    private int id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idannonce")
    private Annonce annonce;

    @Column(name = "path")
    private String path;


    @Column(name = "etat_photo")
    private int etat;
}
