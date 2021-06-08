package com.java.restdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.restdemo.model.Patient;
import com.java.restdemo.model.User;
import com.java.restdemo.service.PatientService;

@RestController
public class PatientController {

	@Autowired
	PatientService service;
	
	@PostMapping(path = "/patient/register")
    public String createPatient(@RequestBody Patient patient)
                                                    throws Exception {
        String output= service.registerPatient(patient);
        return output;
    }
	
	
	@GetMapping(path = "/patient/{patientId}")
	public Patient getUser(@PathVariable("patientId") int patientId) throws Exception {

		Patient patient = service.findOne(patientId);
		return patient;
	}
	
	@GetMapping(path = "/patients")
	public List <Patient> getAllPatients() throws Exception {
		System.out.println("in patinets");
		List<Patient> patients = service.findAll();
		return patients;
	}
	
}
