package com.masai.Models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity

public class VaccineRegistration {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
private Integer regId;
	
	private String mobileno;
	
	private LocalDate dateofregistration;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Member> members = new ArrayList<>();

	public VaccineRegistration() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VaccineRegistration(Integer regId, String mobileno, LocalDate dateofregistration, List<Member> members) {
		super();
		this.regId = regId;
		this.mobileno = mobileno;
		this.dateofregistration = dateofregistration;
		this.members = members;
	}
	public Integer getRegId() {
		return regId;
	}


	public void setRegId(Integer regId) {
		this.regId = regId;
	}


	public String getMobileno() {
		return mobileno;
	}


	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}


	public LocalDate getDateofregistration() {
		return dateofregistration;
	}


	public void setDateofregistration(LocalDate dateofregistration) {
		this.dateofregistration = dateofregistration;
	}


	public List<Member> getMembers() {
		return members;
	}


	public void setMembers(List<Member> members) {
		this.members = members;
	}


	@Override
	public int hashCode() {
		return Objects.hash(dateofregistration, mobileno, regId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VaccineRegistration other = (VaccineRegistration) obj;
		return Objects.equals(dateofregistration, other.dateofregistration) && Objects.equals(mobileno, other.mobileno)
				&& Objects.equals(regId, other.regId);
	}
	
	
	@Override
	public String toString() {
		return "VaccineRegistration [regId=" + regId + ", mobileno=" + mobileno + ", dateofregistration="
				+ dateofregistration + "]";
	}
	
	
	
}





