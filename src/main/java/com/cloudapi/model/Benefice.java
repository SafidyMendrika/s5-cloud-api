package com.cloudapi.model;

import java.sql.Date;

import com.cloudapi.dto.BeneficeDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import jakarta.persistence.Query;

@Data
@Entity
@Table(name = "benefices")
public class Benefice {
    @Id
    @Column(name = "id_benefice")
    private int id;
    
    @Column(name = "benefice")
    private double benefice;

    @OneToOne
    @JoinColumn(name = "idannonce" , referencedColumnName = "id_annonce" ,nullable = true)
    private Annonce annonce;

    @Column(name = "date",nullable = true)
    private Date date;

    public BeneficeDTO getRealBenefice(EntityManager entityManager,Date dateA , Date dateB){
        BeneficeDTO b = null;

        Query query = null;
        if (dateA == null && dateB == null) {
            query = entityManager.createNativeQuery("SELECT * FROM v_benefice",BeneficeDTO.class);
            
        }else{
            query = entityManager.createNativeQuery("SELECT sum(benefice) as benefice FROM benefices WHERE date between ? and ?",BeneficeDTO.class);
            query.setParameter(1, dateA);
            query.setParameter(2, dateB);
        }

        b = (BeneficeDTO) query.getSingleResult();

        return b;
    }
}
