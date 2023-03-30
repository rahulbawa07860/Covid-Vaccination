package com.masai.Models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer memberId;
	
	private Boolean dose1Status = false;
	
	private Boolean dose2Status = false;
	
	private LocalDate dose1Date = null;
	
	private LocalDate dose2Date = null;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Appointment appointment;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Vaccine vaccine;
	
	@OneToOne(cascade = CascadeType.ALL)
	private IdCard idCard;
	
	@OneToOne(cascade = CascadeType.ALL)
	private VaccineRegistration vaccineRegistration;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(Integer memberId, Boolean dose1Status, Boolean dose2Status, LocalDate dose1Date,
			LocalDate dose2Date, Appointment appointment, Vaccine vaccine, IdCard idCard,
			VaccineRegistration vaccineRegistration) {
		super();
		this.memberId = memberId;
		this.dose1Status = dose1Status;
		this.dose2Status = dose2Status;
		this.dose1Date = dose1Date;
		this.dose2Date = dose2Date;
		this.appointment = appointment;
		this.vaccine = vaccine;
		this.idCard = idCard;
		this.vaccineRegistration = vaccineRegistration;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Boolean getDose1Status() {
		return dose1Status;
	}

	public void setDose1Status(Boolean dose1Status) {
		this.dose1Status = dose1Status;
	}

	public Boolean getDose2Status() {
		return dose2Status;
	}

	public void setDose2Status(Boolean dose2Status) {
		this.dose2Status = dose2Status;
	}

	public LocalDate getDose1Date() {
		return dose1Date;
	}

	public void setDose1Date(LocalDate dose1Date) {
		this.dose1Date = dose1Date;
	}

	public LocalDate getDose2Date() {
		return dose2Date;
	}

	public void setDose2Date(LocalDate dose2Date) {
		this.dose2Date = dose2Date;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public Vaccine getVaccine() {
		return vaccine;
	}

	public void setVaccine(Vaccine vaccine) {
		this.vaccine = vaccine;
	}

	public IdCard getIdCard() {
		return idCard;
	}

	public void setIdCard(IdCard idCard) {
		this.idCard = idCard;
	}

	public VaccineRegistration getVaccineRegistration() {
		return vaccineRegistration;
	}

	public void setVaccineRegistration(VaccineRegistration vaccineRegistration) {
		this.vaccineRegistration = vaccineRegistration;
	}

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", dose1Status=" + dose1Status + ", dose2Status=" + dose2Status
				+ ", dose1Date=" + dose1Date + ", dose2Date=" + dose2Date + ", appointment=" + appointment + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(appointment, dose1Date, dose1Status, dose2Date, dose2Status, memberId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		return Objects.equals(appointment, other.appointment) && Objects.equals(dose1Date, other.dose1Date)
				&& Objects.equals(dose1Status, other.dose1Status) && Objects.equals(dose2Date, other.dose2Date)
				&& Objects.equals(dose2Status, other.dose2Status) && Objects.equals(memberId, other.memberId);
	}
	
	
	
	

}
