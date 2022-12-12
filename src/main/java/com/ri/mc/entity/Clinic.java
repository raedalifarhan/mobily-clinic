package com.ri.mc.entity;

import java.sql.Date;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name = "clinic")
public class Clinic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String name;

    private String description;
    
    private String address;
    
    private String medicalOfficerName;
    
    private String dataentryName;

    // is in progress
    private Boolean isActive;

    // is project canceled
    private Boolean isCancel;   

    @CreationTimestamp
    private Date createdAt;
    
    @UpdateTimestamp
    private Date updatedAt;

    // Default fetch type is LAZY
    // @OneToMany( fetch = FetchType.LAZY, ...)
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
        CascadeType.REFRESH, CascadeType.DETACH}, mappedBy = "clinic")
    private Set<Patient> patients;    
}
