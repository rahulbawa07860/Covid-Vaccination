package com.masai.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity


public class Vaccine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer vaccineId;
	private String vaccineName;
	private String description;
	
	public Vaccine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vaccine(Integer vaccineId, String vaccineName, String description) {
		super();
		this.vaccineId = vaccineId;
		this.vaccineName = vaccineName;
		this.description = description;
	}

	public Integer getVaccineId() {
		return vaccineId;
	}

	public void setVaccineId(Integer vaccineId) {
		this.vaccineId = vaccineId;
	}

	public String getVaccineName() {
		return vaccineName;
	}

	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, vaccineId, vaccineName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vaccine other = (Vaccine) obj;
		return Objects.equals(description, other.description) && Objects.equals(vaccineId, other.vaccineId)
				&& Objects.equals(vaccineName, other.vaccineName);
	}

	@Override
	public String toString() {
		return "Vaccine [vaccineId=" + vaccineId + ", vaccineName=" + vaccineName + ", description=" + description
				+ "]";
	}
	
	
	
	
	

}
