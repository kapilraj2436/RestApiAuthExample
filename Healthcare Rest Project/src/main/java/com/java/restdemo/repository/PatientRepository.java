package com.java.restdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import  com.java.restdemo.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

}