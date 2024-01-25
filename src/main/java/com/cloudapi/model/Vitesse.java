package com.cloudapi.model;

import java.util.List;
import java.util.stream.Collectors;

import com.cloudapi.dto.VitesseDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Query;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;


@Data
@Entity
@Table(name = "Vitesses")
public class Vitesse {
    @Id
    @Column(name = "id_vitesse")
    private int id;

    @Column(name = "nom_vitesse")
    private String nom;

    @Column(name="etat_Vitesse")
    private int etat;


    @SuppressWarnings(value = "unchecked")
    public List<Vitesse> findAll(EntityManager entityManager){
        String sql = "SELECT * FROM Vitesses where etat_Vitesse>=0";
        Query query = entityManager.createNativeQuery(sql, Vitesse.class);
        List<Vitesse> Vitesses = (List<Vitesse>) query.getResultList();

        return Vitesses;
    }


    public Vitesse findById(EntityManager entityManager, int id){
        String sql = "SELECT * FROM Vitesses where id_vitesse=?";
        Query query = entityManager.createNativeQuery(sql, Vitesse.class);
        query.setParameter(1, id);
        return (Vitesse) query.getSingleResult();
    }


    public Vitesse insert(EntityManager entityManager, VitesseDTO VitesseDTO){
        String sql = """
                INSERT INTO Vitesses (nom_vitesse) VALUES
                (?) RETURNING *
                """;
        Query query = entityManager.createNativeQuery(sql, Vitesse.class);
        query.setParameter(1, VitesseDTO.getNom());
        return (Vitesse) query.getSingleResult();
    }


    public Vitesse update(EntityManager entityManager,int id, VitesseDTO VitesseDTO){
        String sql = "UPDATE Vitesses set nom_vitesse = ? where id_vitesse=? RETURNING *";
        Query query = entityManager.createNativeQuery(sql, Vitesse.class);
        query.setParameter(1, VitesseDTO.getNom());
        query.setParameter(2, id);
        return (Vitesse) query.getSingleResult();
    }


    public Vitesse delete(EntityManager entityManager,int id){
        String sql = "UPDATE Vitesses set etat_Vitesse=-10 where id_vitesse=? RETURNING *";
        Query query = entityManager.createNativeQuery(sql, Vitesse.class);
        query.setParameter(1, id);
        return (Vitesse) query.getSingleResult();
    }
    

    

}
