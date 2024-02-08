package com.cloudapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cloudapi.model.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
    Optional<Utilisateur> findByEmail(String email);



    @Query(nativeQuery = true, value = """
            SELECT * from utilisateurs where id_utilisateur = :id and etat_utilisateur >=0
            """)
    Optional<Utilisateur> findById(int id);
}
