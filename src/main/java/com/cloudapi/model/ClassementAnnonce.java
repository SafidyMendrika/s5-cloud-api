package com.cloudapi.model;

import java.util.List;

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
@Table(name = "v_top_annonces")
public class ClassementAnnonce {
    @Id
    // @OneToOne
    // @JoinColumn(name = "idannonce", referencedColumnName = "id_annonce",nullable = true)
    @Column(name = "idannonce")
    private int annonce;

    @Column(name = "count")
    private int count;    

    public List<ClassementAnnonce> findTop(EntityManager entityManager,int top){
        List<ClassementAnnonce> classement = null;

        Query query = null;

        if (top != -1) {
            query = entityManager.createNativeQuery("SELECT * FROM v_top_annonces limit ?",ClassementAnnonce.class);
            query.setParameter(1, top);
        }else{
            query = entityManager.createNativeQuery("SELECT * FROM v_top_annonces",ClassementAnnonce.class);
        }

        classement = query.getResultList();
        return classement;
    }

    public ClassementAnnonce() {
    }

    public ClassementAnnonce(int annonce, int count) {
        this.annonce = annonce;
        this.count = count;
    }

    
}
