package com.masai.Models;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
//import lombok.Data;

@Entity
//@Data             // Generate all getter setter+constructor +to string automatically.(Not Working);
public class VaccinationCenter {
	
	
	@Id           // declare id
	@GeneratedValue(strategy = GenerationType.AUTO)   // for auto generation id no
	private Integer centerCode;
	
	
	private String name;
	

	private String address;
	
	@OneToOne(cascade = CascadeType.ALL)   // One Vaccination center can have only one Inventory.
    @NotNull
	private VaccineInventory inventory;
	
	
	@OneToMany    //// One Vaccination center can have many Appointment.
	@JsonIgnore
	List<Appointment> appointments = new ArrayList<>();


	public VaccinationCenter() {
		super();
	}


	public VaccinationCenter(Integer centerCode, String name, String address, VaccineInventory inventory,
			List<Appointment> appointments) {
		super();
		this.centerCode = centerCode;
		this.name = name;
		this.address = address;
		this.inventory = inventory;
		this.appointments = appointments;
	}


	public Integer getCenterCode() {
		return centerCode;
	}


	public void setCenterCode(Integer centerCode) {
		this.centerCode = centerCode;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public VaccineInventory getInventory() {
		return inventory;
	}


	public void setInventory(VaccineInventory inventory) {
		this.inventory = inventory;
	}


	public List<Appointment> getAppointments() {
		return appointments;
	}


	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}


	@Override
	public String toString() {
		return "VaccinationCenter [centerCode=" + centerCode + ", name=" + name + ", address=" + address
				+ ", appointments=" + appointments + "]";
	}
	
	
	
	
}