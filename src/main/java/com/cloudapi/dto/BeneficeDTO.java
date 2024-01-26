package com.cloudapi.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "v_benefice")
public class BeneficeDTO {
    @Id
    @Column(name = "benefice")
    private double benefice;

    public BeneficeDTO() {
    }

    public BeneficeDTO(double benefice) {
        this.benefice = benefice;
    }
    
}
