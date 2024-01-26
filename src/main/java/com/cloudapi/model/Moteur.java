package com.cloudapi.model;

import java.util.List;

import com.cloudapi.dto.MoteurDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Id;
import jakarta.persistence.Query;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "moteurs")
public class Moteur {
    @Id
    @Column(name = "id_moteur")
    private int id;

    @Column(name = "nom_moteur")
    private String nom;

    @Column(name="etat_moteur")
    private int etat;


    @SuppressWarnings(value = "unchecked")
    public List<Moteur> findAll(EntityManager entityManager){
        String sql = "SELECT * FROM moteurs where etat_moteur>=0";
        Query query = entityManager.createNativeQuery(sql, Moteur.class);
        List<Moteur> moteurs = (List<Moteur>) query.getResultList();

        return moteurs;
    }


    public Moteur findById(EntityManager entityManager, int id){
        String sql = "SELECT * FROM moteurs where id_moteur=?";
        Query query = entityManager.createNativeQuery(sql, Moteur.class);
        query.setParameter(1, id);
        return (Moteur) query.getSingleResult();
    }


    public Moteur insert(EntityManager entityManager, MoteurDTO moteurDTO){
        String sql = """
                INSERT INTO moteurs (nom_moteur) VALUES
                (?) RETURNING *
                """;
        Query query = entityManager.createNativeQuery(sql, Moteur.class);
        query.setParameter(1, moteurDTO.getNom());
        return (Moteur) query.getSingleResult();
    }


    public Moteur update(EntityManager entityManager,int id, MoteurDTO moteurDTO){
        String sql = "UPDATE moteurs set nom_moteur = ? where id_moteur=? RETURNING *";
        Query query = entityManager.createNativeQuery(sql, Moteur.class);
        query.setParameter(1, moteurDTO.getNom());
        query.setParameter(2, id);
        return (Moteur) query.getSingleResult();
    }


    public Moteur delete(EntityManager entityManager,int id){
        String sql = "UPDATE moteurs set etat_moteur=-10 where id_moteur=? RETURNING *";
        Query query = entityManager.createNativeQuery(sql, Moteur.class);
        query.setParameter(1, id);
        return (Moteur) query.getSingleResult();
    }
    

    

}
