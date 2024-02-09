package com.cloudapi.model;

import com.cloudapi.repository.UtilisateurRepository;

import lombok.Data;

@Data
public class MessageUtilisateur {
    int id_utilisateur;
    String nom_utilisateur;
    String mail_utilisateur;

    public void completeData(UtilisateurRepository utilisateurRepository){
        System.out.println(id_utilisateur + " user ");
        Utilisateur u = utilisateurRepository.findById(id_utilisateur).get();

        this.setMail_utilisateur(u.getEmail());
        this.setNom_utilisateur(u.getNom());
    }
}
