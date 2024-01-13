package com.cloudapi.model;

import java.util.List;

import com.cloudapi.dto.UtilisateurDTO;
import com.cloudapi.json.Response;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Query;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "utilisateurs")
public class Utilisateur {
    @Id
    @Column(name = "id_utilisateur")
    private int id;

    @Column(name = "nom_utilisateur")
    private String nom;

    @Column(name = "email_utilisateur")
    private String email;

    @Column(name = "password_utilisateur")
    private String password;

    @Column(name = "statut_utilisateur")
    private int statut;

    @Column(name = "etat_utilisateur")
    private int etat;

    @OneToMany(mappedBy = "utilisateur")
    private List<Annonce> annonces;

    @OneToMany(mappedBy = "utilisateur")
    private List<AnnonceFavorite> annonceFavorites;


    public Response verificationLogin(EntityManager entityManager,String email, String mdp)throws Exception{
        Response rep = new Response();
        String sql = "SELECT * FROM utilisateurs where email_utilisateur= :email and password_utilisateur = :mdp";
        Query query = entityManager.createNativeQuery(sql, Utilisateur.class);
        query.setParameter("email", email);
        query.setParameter("mdp", mdp);
        List<Utilisateur> users = (List<Utilisateur>) query.getResultList();
        if (users.size()==0){
            throw new Exception("Mot de passe ou email invalide");
        }
        Session session = new Session().insert(entityManager, users.get(0).id);
        rep.success("Connection avec succès",session);
        return rep;
    }

    public List<Utilisateur> findAll(EntityManager entityManager){
        String sql = "SELECT * FROM utilisateurs where etat_utilisateur>=0";
        Query query = entityManager.createNativeQuery(sql, Utilisateur.class);
        return (List<Utilisateur>) query.getResultList();
    }


    public Utilisateur findById(EntityManager entityManager, int id){
        String sql = "SELECT * FROM utilisateurs where id_utilisateur=?";
        Query query = entityManager.createNativeQuery(sql, Utilisateur.class);
        query.setParameter(1, id);
        return (Utilisateur) query.getSingleResult();
    }


    public Utilisateur insert(EntityManager entityManager, UtilisateurDTO utilisateurDTO){
        String sql = """
                INSERT INTO utilisateurs (nom_utilisateur, email_utilisateur, password_utilisateur, statut_utilisateur) VALUES
                (?, ?, ?, 0) RETURNING *
                """;
        Query query = entityManager.createNativeQuery(sql, Utilisateur.class);
        query.setParameter(1, utilisateurDTO.getNom());
        query.setParameter(2, utilisateurDTO.getEmail());
        query.setParameter(3, utilisateurDTO.getMdp());
        return (Utilisateur) query.getSingleResult();
    }


    public Utilisateur update(EntityManager entityManager,int id, UtilisateurDTO utilisateurDTO){
        String sql = "UPDATE Utilisateurs set nom_utilisateur= ?, email_utilisateur = ?, password_utilisateur= ? where id_utilisateur=? RETURNING *";
        Query query = entityManager.createNativeQuery(sql, Utilisateur.class);
        query.setParameter(1, utilisateurDTO.getNom());
        query.setParameter(2, utilisateurDTO.getEmail());
        query.setParameter(3, utilisateurDTO.getMdp());
        query.setParameter(4, id);
        return (Utilisateur) query.getSingleResult();
    }


    public Utilisateur delete(EntityManager entityManager,int id){
        String sql = "UPDATE Utilisateurs set etat_utilisateur=-10 where id_utilisateur=? RETURNING *";
        Query query = entityManager.createNativeQuery(sql, Utilisateur.class);
        query.setParameter(1, id);
        return (Utilisateur) query.getSingleResult();
    }



    
}
