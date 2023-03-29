package com.masai.Models;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer memberId;
	
	private Boolean dose1Status = false;
	
	private Boolean dose2Status = false;
	
	private LocalDateTime dose1Date = null;
	
	private LocalDateTime dose2Date = null;
	
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

}
