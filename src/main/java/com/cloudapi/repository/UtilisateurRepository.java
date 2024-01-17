package com.cloudapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cloudapi.model.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
    Optional<Utilisateur> findByEmail(String email);
}
