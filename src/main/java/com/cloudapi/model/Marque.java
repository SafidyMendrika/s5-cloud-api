package com.cloudapi.model;

import java.util.List;

import com.cloudapi.dto.MarqueDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Id;
import jakarta.persistence.Query;
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


    public List<Marque> findAll(EntityManager entityManager){
        String sql = "SELECT * FROM marques where etat_marque>=0";
        Query query = entityManager.createNativeQuery(sql, Marque.class);
        return (List<Marque>) query.getResultList();
    }


    public Marque findById(EntityManager entityManager, int id){
        String sql = "SELECT * FROM marques where id_marque=?";
        Query query = entityManager.createNativeQuery(sql, Marque.class);
        query.setParameter(1, id);
        return (Marque) query.getSingleResult();
    }


    public Marque insert(EntityManager entityManager, MarqueDTO marqueDTO){
        String sql = """
                INSERT INTO Marques (nom_marque) VALUES
                (?) RETURNING *
                """;
        Query query = entityManager.createNativeQuery(sql, Marque.class);
        query.setParameter(1, marqueDTO.getNom());
        return (Marque) query.getSingleResult();
    }


    public Marque update(EntityManager entityManager,int id, MarqueDTO marqueDTO){
        String sql = "UPDATE Marques set nom_marque = ? where id_marque=? RETURNING *";
        Query query = entityManager.createNativeQuery(sql, Marque.class);
        query.setParameter(1, marqueDTO.getNom());
        query.setParameter(2, id);
        return (Marque) query.getSingleResult();
    }


    public Marque delete(EntityManager entityManager,int id){
        String sql = "UPDATE Marques set etat_marque=-10 where id_marque=? RETURNING *";
        Query query = entityManager.createNativeQuery(sql, Marque.class);
        query.setParameter(1, id);
        return (Marque) query.getSingleResult();
    }
    

    

}
