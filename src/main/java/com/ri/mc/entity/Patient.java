package com.ri.mc.entity;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // Default fetch type is EAGER
    // @ManyToOne( fetch = FetchType.EAGER, ...)
    @ManyToOne
    @JoinColumn(name = "clinic_id", nullable = false)
    private Clinic clinic;

    private String name;
    
    private Integer Age;
    
    private String address;
    
    private Boolean isResident;
    
    private Boolean isDisabled;
    
    private String phoneNumber;
    
    private Boolean isActive;
    
    @CreationTimestamp
    private Date createdAt;
    
    @UpdateTimestamp
    private Date updatedAt;    
}
