package com.cloudapi.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import com.cloudapi.dto.AnnonceDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Query;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "annonces")
public class Annonce {
    @Id
    @Column(name = "id_annonce")
    private int id;

    @Column(name = "idmodele")
    private int idModele;

    @Column(name= "description_annonce")
    private String description;


    @Column(name = "prix_annonce")
    private double prix;

    @Column(name = "date_validation")
    private LocalDateTime dateValidation;

    @Column(name = "date_annonce")
    private LocalDateTime dateAnnonce;

    @Column(name = "etat_annonce")
    private int etat;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name ="idutilisateur")
    private Utilisateur utilisateur;





    @JsonIgnore
    @OneToMany(mappedBy = "annonce")
    private List<PhotoAnnonce> photoAnnonces;


    public List<PhotoAnnonce> getPhotoAnnonces(){
        return photoAnnonces.stream()
                .filter(photoAnnonce -> photoAnnonce.getEtat() >= 0)
                .collect(Collectors.toList());
    }


    public Annonce confirmer(EntityManager entityManager,int id){
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dFormatter= DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String sql = "UPDATE annonces set etat_annonce=10, date_validation= CAST (? AS TIMESTAMP) where id_annonce=? RETURNING *";
        Query query = entityManager.createNativeQuery(sql, Annonce.class);
        query.setParameter(1, dFormatter.format(date));
        query.setParameter(2, id);
        return (Annonce) query.getSingleResult();
    }

    @SuppressWarnings(value = "unchecked")
    public List<Annonce> findAll(EntityManager entityManager){
        String sql = "SELECT * FROM annonces where etat_annonce>=10";
        Query query = entityManager.createNativeQuery(sql, Annonce.class);
        return (List<Annonce>) query.getResultList();
    }


    public Annonce findById(EntityManager entityManager, int id){
        String sql = "SELECT * FROM annonces where id_annonce=?";
        Query query = entityManager.createNativeQuery(sql, Annonce.class);
        query.setParameter(1, id);
        return (Annonce) query.getSingleResult();
    }


    public Annonce insert(EntityManager entityManager, AnnonceDTO annonceDTO){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String sql = """
                INSERT INTO annonces (idutilisateur, idModele, description_annonce, date_validation, date_annonce) VALUES
                (?, ?, ?, null, CAST (? AS TIMESTAMP)) RETURNING *
                """;
        Query query = entityManager.createNativeQuery(sql, Annonce.class);
        query.setParameter(1, annonceDTO.getIdutilisateur());
        query.setParameter(2, annonceDTO.getIdvoiture());
        query.setParameter(3, annonceDTO.getDescription());
        query.setParameter(4, formatter.format(now));
        return (Annonce) query.getSingleResult();
    }


    public Annonce update(EntityManager entityManager,int id, AnnonceDTO annonceDTO){
        String sql = "UPDATE annonces set idvoiture = ?, idutilisateur= ? , description_annonce= ? where id_annonce = ? RETURNING *";
        Query query = entityManager.createNativeQuery(sql, Annonce.class);
        query.setParameter(1, annonceDTO.getIdvoiture());
        query.setParameter(2, annonceDTO.getIdutilisateur());
        query.setParameter(3, annonceDTO.getDescription());
        query.setParameter(4, id);
        return (Annonce) query.getSingleResult();
    }


    public Annonce delete(EntityManager entityManager,int id){
        String sql = "UPDATE annonces set etat_annonce=-10 where id_annonce=? RETURNING *";
        Query query = entityManager.createNativeQuery(sql, Annonce.class);
        query.setParameter(1, id);
        return (Annonce) query.getSingleResult();
    }



    
}
