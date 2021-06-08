package com.java.restdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.restdemo.model.Patient;
import com.java.restdemo.repository.PatientRepository;

@Service
public class PatientService  {

	@Autowired
	private PatientRepository repo;

	public List<Patient> findAll() {
		List<Patient> patients = (List<Patient>) repo.findAll();
		return patients;
	}

	public Patient findOne(int id) throws Exception {
		Optional<Patient> patient =  repo.findById(id);
		 if(patient.isPresent()) {
	            return patient.get();
	        } else {
	            throw new Exception("No patient record exist for given id");
	        }
	}
	public String registerPatient(Patient patient) throws Exception {
		
		Optional<Patient> o_patient = repo.findById(patient.getPatientId());
		if(o_patient.isPresent()) {
            return "Patient Already Registered.";
        } 
		repo.save(patient);
		return "Patient Registered Successfully";
	}
}
