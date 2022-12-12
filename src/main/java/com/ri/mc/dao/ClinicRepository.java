package com.ri.mc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.ri.mc.entity.Clinic;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "patient", path = "patient")
public interface ClinicRepository extends JpaRepository<Clinic, Long> {
    
}
