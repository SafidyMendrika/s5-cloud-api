package com.cloudapi.model;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.cloudapi.dto.AnnonceFavoriteDTO;
import com.cloudapi.dto.CategorieDTO;
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
@Table(name = "annonces_favorites")
public class AnnonceFavorite {
    @Id
    @Column(name = "id_favori")
    private int id;


    @Column(name = "etat_favori")
    private int etat;

    @OneToOne
    @JoinColumn(name="idannonce", referencedColumnName = "id_annonce")
    private Annonce annonce;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name ="idutilisateur")
    private Utilisateur utilisateur;


    @SuppressWarnings(value = "unchecked")
    public static List<AnnonceFavorite> delete(EntityManager entityManager, AnnonceFavoriteDTO annonceFavoriteDTO){
        String sql = """
                DELETE FROM annonces_favorites where idutilisateur = ? and idannonce = ? RETURNING *
                """;
        Query query = entityManager.createNativeQuery(sql, AnnonceFavorite.class);
        query.setParameter(1, annonceFavoriteDTO.getIdutilisateur());
        query.setParameter(2, annonceFavoriteDTO.getIdannonce());
        return (List<AnnonceFavorite>) query.getResultList();
    }


    public static AnnonceFavorite insert(EntityManager entityManager, AnnonceFavoriteDTO annonceFavoriteDTO){
        String sql = """
                INSERT INTO annonces_favorites (idUtilisateur, idAnnonce) VALUES
                (?, ?) RETURNING *
                """;
        Query query = entityManager.createNativeQuery(sql, AnnonceFavorite.class);
        query.setParameter(1, annonceFavoriteDTO.getIdutilisateur());
        query.setParameter(2, annonceFavoriteDTO.getIdannonce());
        return (AnnonceFavorite) query.getSingleResult();
    }

}
