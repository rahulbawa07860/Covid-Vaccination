package com.masai.Models;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class VaccineInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer inventoryId;
	private LocalDate date;
	@OneToMany
	@JsonIgnore
	private Set<VaccineCount> vaccineCount;
	public Integer getInventoryId() {
		return inventoryId;
	}
	public void setInventoryId(Integer inventoryId) {
		this.inventoryId = inventoryId;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Set<VaccineCount> getVaccineCount() {
		return vaccineCount;
	}
	public void setVaccineCount(Set<VaccineCount> vaccineCount) {
		this.vaccineCount = vaccineCount;
	}
	@Override
	public int hashCode() {
		return Objects.hash(date, inventoryId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VaccineInventory other = (VaccineInventory) obj;
		return Objects.equals(date, other.date) && Objects.equals(inventoryId, other.inventoryId);
	}
	@Override
	public String toString() {
		return "VaccineInventory [inventoryId=" + inventoryId + ", date=" + date + "]";
	}
	
	
}
