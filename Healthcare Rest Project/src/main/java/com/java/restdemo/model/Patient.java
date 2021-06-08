package com.java.restdemo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Patient")
public class Patient implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int patientId;
	public String patientName;
	public String userId;
	public String patientMobile;

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPatientMobile() {
		return patientMobile;
	}

	public void setPatientMobile(String patientMobile) {
		this.patientMobile = patientMobile;
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientName=" + patientName + ", userId=" + userId
				+ ", patientMobile=" + patientMobile + "]";
	}

}
