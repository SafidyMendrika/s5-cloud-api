package com.cloudapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
    @Column(name = "idannonce")
    private int idannonce;

    @Column(name = "path")
    private String path;


    @Column(name = "etat_photo")
    private int etat;
}
