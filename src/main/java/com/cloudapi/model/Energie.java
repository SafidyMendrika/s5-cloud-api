package com.cloudapi.model;

import java.util.List;

import com.cloudapi.dto.EnergieDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Id;
import jakarta.persistence.Query;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "energies")
public class Energie {
    @Id
    @Column(name = "id_energie")
    private int id;

    @Column(name = "nom_energie")
    private String nom;

    @Column(name="etat_energie")
    private int etat;


    @SuppressWarnings(value = "unchecked")
    public List<Energie> findAll(EntityManager entityManager){
        String sql = "SELECT * FROM Energies where etat_energie>=0";
        Query query = entityManager.createNativeQuery(sql, Energie.class);
        List<Energie> Energies = (List<Energie>) query.getResultList();

        return Energies;
    }


    public Energie findById(EntityManager entityManager, int id){
        String sql = "SELECT * FROM Energies where id_energie=?";
        Query query = entityManager.createNativeQuery(sql, Energie.class);
        query.setParameter(1, id);
        return (Energie) query.getSingleResult();
    }


    public Energie insert(EntityManager entityManager, EnergieDTO EnergieDTO){
        String sql = """
                INSERT INTO Energies (nom_energie) VALUES
                (?) RETURNING *
                """;
        Query query = entityManager.createNativeQuery(sql, Energie.class);
        query.setParameter(1, EnergieDTO.getNom());
        return (Energie) query.getSingleResult();
    }


    public Energie update(EntityManager entityManager,int id, EnergieDTO EnergieDTO){
        String sql = "UPDATE Energies set nom_energie = ? where id_energie=? RETURNING *";
        Query query = entityManager.createNativeQuery(sql, Energie.class);
        query.setParameter(1, EnergieDTO.getNom());
        query.setParameter(2, id);
        return (Energie) query.getSingleResult();
    }


    public Energie delete(EntityManager entityManager,int id){
        String sql = "UPDATE Energies set etat_energie=-10 where id_energie=? RETURNING *";
        Query query = entityManager.createNativeQuery(sql, Energie.class);
        query.setParameter(1, id);
        return (Energie) query.getSingleResult();
    }
    

    

}
