package com.cloudapi.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import com.cloudapi.dto.CommissionDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Id;
import jakarta.persistence.Query;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "Commissions")
public class Commission {
    @Id
    @Column(name = "id_commission")
    private int id;

    @Column(name = "commission")
    private double commission;

    @Column(name="date_insertion")
    private Timestamp dateInsertion;

    @SuppressWarnings(value = "unchecked")
    public Commission findLast(EntityManager entityManager){
        String sql = "SELECT * FROM Commissions order by date_insertion DESC";
        Query query = entityManager.createNativeQuery(sql, Commission.class);
        List<Commission> Commissions = (List<Commission>) query.getResultList();
        if (Commissions.size() == 0) return null;
        return Commissions.get(0);
    }


    @SuppressWarnings(value = "unchecked")
    public List<Commission> findAll(EntityManager entityManager){
        String sql = "SELECT * FROM Commissions order by date_insertion DESC";
        Query query = entityManager.createNativeQuery(sql, Commission.class);
        List<Commission> Commissions = (List<Commission>) query.getResultList();

        return Commissions;
    }


    public Commission find(EntityManager entityManager){
        String sql = "SELECT * FROM v_current_commission ";
        Query query = entityManager.createNativeQuery(sql, Commission.class);
        return (Commission) query.getSingleResult();
    }


    public Commission insert(EntityManager entityManager, CommissionDTO CommissionDTO){
        String sql = """
                INSERT INTO Commissions (commission,date_insertion) VALUES
                (?,?) RETURNING *
                """;
        Query query = entityManager.createNativeQuery(sql, Commission.class);
        query.setParameter(1, CommissionDTO.getCommission());
        query.setParameter(2, Timestamp.valueOf(LocalDateTime.now()));
        return (Commission) query.getSingleResult();
    }

}
