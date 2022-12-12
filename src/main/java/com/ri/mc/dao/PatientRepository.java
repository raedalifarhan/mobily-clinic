package com.ri.mc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.ri.mc.entity.Patient;

// Name of JSON Entry is: patient
// actual Reference for the path is: patient 

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "patient", path = "patient")
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
