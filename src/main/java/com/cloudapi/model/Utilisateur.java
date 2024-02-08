package com.cloudapi.model;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cloudapi.dto.UtilisateurDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Query;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
@AllArgsConstructor
@Entity
@Table(name = "utilisateurs")
public class Utilisateur implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_utilisateur")
    private int id;

    @Column(name = "nom_utilisateur")
    private String nom;

    @Column(name = "email_utilisateur")
    private String email;


    @Column(name = "telephone_utilisateur")
    private String telephone;


    @Column(name = "date_naissance")
    private LocalDate date;

    
    private Integer genre;


    @JsonIgnore
    @Column(name = "password_utilisateur")
    private String password;


    @Column(name = "etat_utilisateur")
    private int etat;

    @JsonIgnore
    @OneToMany(mappedBy = "utilisateur")
    private List<Annonce> annonces;

    @JsonIgnore
    @OneToMany(mappedBy = "utilisateur")
    private List<AnnonceFavorite> annonceFavorites;

    @Column(name = "statut_utilisateur")
    private int role;


    public MessageUtilisateur toMessageUtilisateur(){
        MessageUtilisateur messageUtilisateur = new MessageUtilisateur();

        messageUtilisateur.setId_utilisateur(this.getId());
        messageUtilisateur.setMail_utilisateur(this.getEmail());
        messageUtilisateur.setNom_utilisateur(this.getNom());

        return  messageUtilisateur;
    }

    public Utilisateur() {
    }


    public List<Annonce> getAnnonceFavorites(){
        return annonces.stream()
                .filter(element -> element.getEtat() >= 0)
                .collect(Collectors.toList()); 
    }


    public List<Annonce> getAnnonces(){
        return annonces.stream()
                .filter(element -> element.getEtat() >= 0)
                .collect(Collectors.toList()); 
    }



    @SuppressWarnings(value = "unchecked")
    public List<Utilisateur> findAll(EntityManager entityManager){
        String sql = "SELECT * FROM utilisateurs where etat_utilisateur=0 and statut_utilisateur=0";
        Query query = entityManager.createNativeQuery(sql, Utilisateur.class);
        return (List<Utilisateur>) query.getResultList();
    }

    
    public  static Utilisateur findById(EntityManager entityManager, int id){
        String sql = "SELECT * FROM utilisateurs where id_utilisateur=?";
        Query query = entityManager.createNativeQuery(sql, Utilisateur.class);
        query.setParameter(1, id);
        return (Utilisateur) query.getSingleResult();
    }

    public  static Long findNombreUtilisateur(EntityManager entityManager){
        String sql = "SELECT count(*) FROM utilisateurs where statut_utilisateur!= 10";
        Query query = entityManager.createNativeQuery(sql);
        return (Long) query.getSingleResult();
    }

    public Utilisateur insert(EntityManager entityManager, UtilisateurDTO utilisateurDTO){
        String sql = """
                INSERT INTO utilisateurs (nom_utilisateur, email_utilisateur,telephone_utilisateur,date_naissance ,genre, password_utilisateur, statut_utilisateur) VALUES
                (?, ?, ?, ?, CAST (? as DATE), ?, 0) RETURNING *
                """;
        Query query = entityManager.createNativeQuery(sql, Utilisateur.class);
        query.setParameter(1, utilisateurDTO.getNom());
        query.setParameter(2, utilisateurDTO.getEmail());
        query.setParameter(3, utilisateurDTO.getMdp());
        query.setParameter(4, utilisateurDTO.getTelephone());
        query.setParameter(5, utilisateurDTO.getDate());
        query.setParameter(6, utilisateurDTO.getGenre());
        return (Utilisateur) query.getSingleResult();
    }


    public Utilisateur update(EntityManager entityManager,int id, UtilisateurDTO utilisateurDTO){
        String sql = "UPDATE Utilisateurs set nom_utilisateur= ?, email_utilisateur = ?, password_utilisateur= ?, telephone_utilisateur= ?, genre= ?, date_naissance = CAST ( ? AS DATE) where id_utilisateur=? RETURNING *";
        Query query = entityManager.createNativeQuery(sql, Utilisateur.class);
        query.setParameter(1, utilisateurDTO.getNom());
        query.setParameter(2, utilisateurDTO.getEmail());
        query.setParameter(3, utilisateurDTO.getMdp());
        query.setParameter(4, utilisateurDTO.getTelephone());
        query.setParameter(5, utilisateurDTO.getGenre());
        query.setParameter(6, utilisateurDTO.getDate());
        query.setParameter(7, id);
        return (Utilisateur) query.getSingleResult();
    }


    public Utilisateur delete(EntityManager entityManager,int id){
        String sql = "UPDATE Utilisateurs set etat_utilisateur=-10 where id_utilisateur=? RETURNING *";
        Query query = entityManager.createNativeQuery(sql, Utilisateur.class);
        query.setParameter(1, id);
        return (Utilisateur) query.getSingleResult();
    }



    public String getGenre(){
        switch (genre) {
            case 0:
                return "Fmme";
            case 1:
                return "Homme";
            default:
                return "Homme";
        }
    }


    @JsonIgnore
    public String getRole(){
        switch (role) {
            case 0:
                return "USER";
            case 10:
                return "ADMIN";
            default:
                return "USER";
        }
    }


    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_"+getRole()));
    }


    @JsonIgnore
    @Override
    public String getUsername() {
        return email;
    }


    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }


    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }


    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }


    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    


    



    
}
