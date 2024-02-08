package com.cloudapi.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.springframework.web.multipart.MultipartFile;

import com.cloudapi.dto.AnnonceDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Blob;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.StorageClient;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Query;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;


@Data
@Entity
@Table(name = "annonces")
public class Annonce {
    @Id
    @Column(name = "id_annonce")
    private int id;


    @OneToOne
    @JoinColumn(name = "idmodele", referencedColumnName = "id_modele")
    private Modele modele;

    @Column(name= "description_annonce")
    private String description;


    @Column(name = "prix_annonce")
    private double prix;

    @Column(name = "date_validation")
    private LocalDateTime dateValidation;

    @Column(name = "date_annonce")
    private LocalDateTime dateAnnonce;

    @OneToOne
    @JoinColumn(name = "idmoteur" ,referencedColumnName = "id_moteur")
    private Moteur moteur;

    @OneToOne
    @JoinColumn(name = "idvitesse" ,referencedColumnName = "id_vitesse")
    private Vitesse vitesse;


    @OneToOne
    @JoinColumn(name = "idenergie", referencedColumnName = "id_energie")
    private Energie energie;

    @Column(name = "etat_annonce")
    private int etat;



    @ManyToOne
    @JoinColumn(name ="idutilisateur")
    private Utilisateur utilisateur;





    @OneToMany(mappedBy = "annonce")
    private List<PhotoAnnonce> photoAnnonces;


    @Transient
    private int count;





    public List<PhotoAnnonce> getPhotoAnnonces(){
        return photoAnnonces.stream()
                .filter(photoAnnonce -> photoAnnonce.getEtat() >= 0)
                .collect(Collectors.toList());
    }



    @SuppressWarnings(value = "unchecked")
    public List<Annonce> findAllActualite(EntityManager entityManager, int iduser){
        String sql = "SELECT * FROM annonces where etat_annonce>=0 and idutilisateur != :id";
        Query query = entityManager.createNativeQuery(sql, Annonce.class);
        query.setParameter("id", iduser);
        List<Annonce> annonces = (List<Annonce>) query.getResultList();
        for (Annonce annonce : annonces) {
            annonce.setCount(annonce.countFavoris(entityManager));
        }
        return annonces;
    }



    public int countFavoris(EntityManager entityManager){
        String sql = "SELECT * FROM annonces_favorites where idannonce = :id";
        Query query = entityManager.createNativeQuery(sql, AnnonceFavorite.class);
        query.setParameter("id", id);
        return query.getResultList().size();
        
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
        String sql = "SELECT * FROM annonces where etat_annonce>=0";
        Query query = entityManager.createNativeQuery(sql, Annonce.class);
        List<Annonce> annonces =  (List<Annonce>) query.getResultList();
        for (Annonce annonce : annonces) {
            annonce.setCount(annonce.countFavoris(entityManager));
        }
        return annonces;
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
                INSERT INTO annonces (idutilisateur, idModele, description_annonce, prix_annonce ,date_validation, date_annonce, idenergie, idvitesse, idmoteur) VALUES
                (?, ?, ?, ?, null, CAST (? AS TIMESTAMP), ?, ?, ?) RETURNING *
                """;
        Query query = entityManager.createNativeQuery(sql, Annonce.class);
        query.setParameter(1, annonceDTO.getIdutilisateur());
        query.setParameter(2, annonceDTO.getIdmodele());
        query.setParameter(3, annonceDTO.getDescription());
        query.setParameter(4, annonceDTO.getPrix());
        query.setParameter(5, formatter.format(now));
        query.setParameter(6, annonceDTO.getIdenergie());
        query.setParameter(7, annonceDTO.getIdvitesse());
        query.setParameter(8, annonceDTO.getIdmoteur());
        return (Annonce) query.getSingleResult();
    }


    public Annonce update(EntityManager entityManager,int id, AnnonceDTO annonceDTO){
        String sql = "UPDATE annonces set idmodele = ?, idutilisateur= ? , description_annonce= ?, prix_annonce = ?, idenergie= ?, idmoteur=?, idvitesse=?, date_annonce=CAST(? as TIMESTAMP) where id_annonce = ? RETURNING *";
        Query query = entityManager.createNativeQuery(sql, Annonce.class);
        query.setParameter(1, annonceDTO.getIdmodele());
        query.setParameter(2, annonceDTO.getIdutilisateur());
        query.setParameter(3, annonceDTO.getDescription());
        query.setParameter(4, annonceDTO.getPrix());
        query.setParameter(5, annonceDTO.getIdenergie());
        query.setParameter(6, annonceDTO.getIdmoteur());
        query.setParameter(7, annonceDTO.getIdvitesse());
        query.setParameter(8, annonceDTO.getDate());
        query.setParameter(9, id);
        return (Annonce) query.getSingleResult();
    }


    public Annonce delete(EntityManager entityManager,int id){
        String sql = "UPDATE annonces set etat_annonce=-10 where id_annonce=? RETURNING *";
        Query query = entityManager.createNativeQuery(sql, Annonce.class);
        query.setParameter(1, id);
        return (Annonce) query.getSingleResult();
    }



    
}
