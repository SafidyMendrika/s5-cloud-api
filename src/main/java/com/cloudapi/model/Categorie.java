package com.cloudapi.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.cloudapi.dto.AnnonceDTO;
import com.cloudapi.dto.CategorieDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Id;
import jakarta.persistence.Query;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "categories")
public class Categorie {
    @Id
    @Column(name = "id_categorie")
    private int id;

    @Column(name = "nom_categorie")
    private String nom;

    @Column(name = "etat_categorie")
    private int etat;


    public List<Categorie> findAll(EntityManager entityManager){
        String sql = "SELECT * FROM categories where etat_categorie>=0";
        Query query = entityManager.createNativeQuery(sql, Categorie.class);
        return (List<Categorie>) query.getResultList();
    }


    public Categorie findById(EntityManager entityManager, int id){
        String sql = "SELECT * FROM categories where id_categorie=?";
        Query query = entityManager.createNativeQuery(sql, Categorie.class);
        query.setParameter(1, id);
        return (Categorie) query.getSingleResult();
    }


    public Categorie insert(EntityManager entityManager, CategorieDTO categorieDTO){
        String sql = """
                INSERT INTO categories (nom_categorie) VALUES
                (?) RETURNING *
                """;
        Query query = entityManager.createNativeQuery(sql, Categorie.class);
        query.setParameter(1, categorieDTO.getNom());
        return (Categorie) query.getSingleResult();
    }


    public Categorie update(EntityManager entityManager,int id, CategorieDTO categorieDTO){
        String sql = "UPDATE categories set nom_categorie = ? where id_categorie=? RETURNING *";
        Query query = entityManager.createNativeQuery(sql, Categorie.class);
        query.setParameter(1, categorieDTO.getNom());
        query.setParameter(2, id);
        return (Categorie) query.getSingleResult();
    }


    public Categorie delete(EntityManager entityManager,int id){
        String sql = "UPDATE categories set etat_categorie=-10 where id_categorie=? RETURNING *";
        Query query = entityManager.createNativeQuery(sql, Categorie.class);
        query.setParameter(1, id);
        return (Categorie) query.getSingleResult();
    }

 
}
