package com.cloudapi.model;

import java.util.List;

import com.cloudapi.dto.ModeleDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Query;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "modeles")
public class Modele {
    @Id
    @Column(name = "id_modele")
    private int id;


    // @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idmarque")
    private Marque marque;

    @OneToOne
    @JoinColumn(name = "idcategorie", referencedColumnName= "id_categorie")
    private Categorie categorie;

    @Column(name = "nom_modele")
    private String nom;

    @Column(name = "etat_modele")
    private int etat;


    @SuppressWarnings(value = "unchecked")
    public List<Modele> findAll(EntityManager entityManager){
        String sql = "SELECT * FROM modeles where etat_modele>=0";
        Query query = entityManager.createNativeQuery(sql, Modele.class);
        return (List<Modele>) query.getResultList();
    }


    public Modele findById(EntityManager entityManager, int id){
        String sql = "SELECT * FROM modeles where id_modele=?";
        Query query = entityManager.createNativeQuery(sql, Modele.class);
        query.setParameter(1, id);
        return (Modele) query.getSingleResult();
    }


    public Modele insert(EntityManager entityManager, ModeleDTO modeleDTO){
        String sql = """
                INSERT INTO modeles (idmarque, idcategorie, nom_modele) VALUES
                (?, ?, ?) RETURNING *
                """;
        Query query = entityManager.createNativeQuery(sql, Modele.class);
        query.setParameter(1, modeleDTO.getIdmarque());
        query.setParameter(2, modeleDTO.getIdcategorie());
        query.setParameter(3, modeleDTO.getNom());
        return (Modele) query.getSingleResult();
    }


    public Modele update(EntityManager entityManager,int id, ModeleDTO modeleDTO){
        String sql = "UPDATE modeles set idmarque= ?,idcategorie= ?,nom_modele = ? where id_modele=? RETURNING *";
        Query query = entityManager.createNativeQuery(sql, Modele.class);
        query.setParameter(1, modeleDTO.getIdmarque());
        query.setParameter(2, modeleDTO.getIdcategorie());
        query.setParameter(3, modeleDTO.getNom());
        query.setParameter(4, id);
        return (Modele) query.getSingleResult();
    }


    public Modele delete(EntityManager entityManager,int id){
        String sql = "UPDATE modeles set etat_modele=-10 where id_modele=? RETURNING *";
        Query query = entityManager.createNativeQuery(sql, Modele.class);
        query.setParameter(1, id);
        return (Modele) query.getSingleResult();
    }


    
}
