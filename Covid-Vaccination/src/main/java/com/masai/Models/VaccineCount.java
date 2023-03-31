package com.masai.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class VaccineCount {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer countid;
	@OneToOne
	private Vaccine vaccine;
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private VaccineInventory inventory;
	
	private Integer inId;
	
	private Integer quantity;

	public VaccineCount() {
		super();
	}

	public VaccineCount(Integer countid, Vaccine vaccine, VaccineInventory inventory, Integer inId, Integer quantity) {
		super();
		this.countid = countid;
		this.vaccine = vaccine;
		this.inventory = inventory;
		this.inId = inId;
		this.quantity = quantity;
	}

	public Integer getCountid() {
		return countid;
	}

	public void setCountid(Integer countid) {
		this.countid = countid;
	}

	public Vaccine getVaccine() {
		return vaccine;
	}

	public void setVaccine(Vaccine vaccine) {
		this.vaccine = vaccine;
	}

	public VaccineInventory getInventory() {
		return inventory;
	}

	public void setInventory(VaccineInventory inventory) {
		this.inventory = inventory;
	}

	public Integer getInId() {
		return inId;
	}

	public void setInId(Integer inId) {
		this.inId = inId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "VaccineCount [countid=" + countid + ", inventory=" + inventory + ", inId=" + inId + ", quantity="
				+ quantity + "]";
	}
}
