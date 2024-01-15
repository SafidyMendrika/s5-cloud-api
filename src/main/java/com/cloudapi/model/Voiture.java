package com.cloudapi.model;

import java.util.List;

import com.cloudapi.dto.VoitureDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Query;
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
    @JoinColumn(name = "idmodele", referencedColumnName = "id_modele")
    private Modele modele;

    @Column(name = "nom_voiture")
    private String nom;

    @Column(name = "etat_voiture")
    private int etat;


    @SuppressWarnings(value = "unchecked")
    public List<Voiture> findAll(EntityManager entityManager){
        String sql = "SELECT * FROM voitures where etat_voiture>=0";
        Query query = entityManager.createNativeQuery(sql, Voiture.class);
        return (List<Voiture>) query.getResultList();
    }


    public Voiture findById(EntityManager entityManager, int id){
        String sql = "SELECT * FROM voitures where id_voiture=?";
        Query query = entityManager.createNativeQuery(sql, Voiture.class);
        query.setParameter(1, id);
        return (Voiture) query.getSingleResult();
    }


    public Voiture insert(EntityManager entityManager, VoitureDTO voitureDTO){
        String sql = """
                INSERT INTO voitures (idModele, nom_voiture) VALUES
                (?, ?) RETURNING *
                """;
        Query query = entityManager.createNativeQuery(sql, Voiture.class);
        query.setParameter(1, voitureDTO.getIdmodele());
        query.setParameter(2, voitureDTO.getNom());
        return (Voiture) query.getSingleResult();
    }


    public Voiture update(EntityManager entityManager,int id, VoitureDTO voitureDTO){
        String sql = "UPDATE Voitures set idmodele= ?, nom = ? where id_voiture=? RETURNING *";
        Query query = entityManager.createNativeQuery(sql, Voiture.class);
        query.setParameter(1, voitureDTO.getIdmodele());
        query.setParameter(2, voitureDTO.getNom());
        query.setParameter(3, id);
        return (Voiture) query.getSingleResult();
    }


    public Voiture delete(EntityManager entityManager,int id){
        String sql = "UPDATE voitures set etat_voiture=-10 where id_voiture=? RETURNING *";
        Query query = entityManager.createNativeQuery(sql, Voiture.class);
        query.setParameter(1, id);
        return (Voiture) query.getSingleResult();
    }

}
