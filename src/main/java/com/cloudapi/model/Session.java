package com.cloudapi.model;

import java.security.SecureRandom;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.Random;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Id;
import jakarta.persistence.Query;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "sessions")
public class Session {
    @Id
    @Column(name = "id_session")
    private int id;

    @JsonIgnore
    @Column(name = "idutilisateur")
    private int idUtilisateur;

    @Column(name = "code")
    private int code;

    @Column(name = "token")
    private String token;

    @Column(name = "date_expiration")
    private LocalDateTime expiration;



    public Session insert(EntityManager entityManager, int idutilisateur){
        String token = generateToken(16);
        int code = Integer.valueOf(generateRandomCode(4));
        LocalDateTime expiration = LocalDateTime.now().plus(Duration.ofHours(1));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String sql = """
                    INSERT INTO sessions (idUtilisateur, code, token, date_expiration) VALUES 
                    (:user, :code, :token, CAST (:date AS TIMESTAMP)) RETURNING *
                    """;
        Query query = entityManager.createNativeQuery(sql, Session.class);
        query.setParameter("user", idutilisateur);
        query.setParameter("code", code);
        query.setParameter("token", token);
        query.setParameter("date", expiration.format(formatter));
        try {
            return (Session) query.getSingleResult();
        } catch (Exception e) {
            token = generateToken(16);
            code = Integer.valueOf(generateRandomCode(4));
            query.setParameter("code", code);
            query.setParameter("token", token);
            return (Session) query.getSingleResult();
        }

    }

    private static String generateRandomCode(int length) {
        Random random = new Random();
        StringBuilder codeBuilder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int digit = random.nextInt(10); // Génère un chiffre entre 0 et 9
            codeBuilder.append(digit);
        }

        return codeBuilder.toString();
    }

    private static String generateToken(int length) {
        SecureRandom secureRandom = new SecureRandom();
        byte[] tokenBytes = new byte[length];
        secureRandom.nextBytes(tokenBytes);

        return Base64.getUrlEncoder().withoutPadding().encodeToString(tokenBytes);
    }

}
