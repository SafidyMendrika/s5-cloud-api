package com.cloudapi.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.amqp.RabbitProperties.Cache.Connection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Id;
import jakarta.persistence.Query;
import lombok.Data;

@Data
@Entity
public class NombreAnnonceParMois {
    @Id
    @Column(name = "mois")
    private int mois;

    @Column(name = "nombre_annonces_benefices")
    private int vendus;

    @Column(name = "nombre_total_annonces")
    private int annonces;

    public List<NombreAnnonceParMois> findAByYear(EntityManager entityManager,int year) throws Exception{
        
        Query query = entityManager.createNativeQuery("SELECT * FROM get_annonces_et_benefices(?)",NombreAnnonceParMois.class);
        query.setParameter(1, year);

        return query.getResultList();
    }
}
