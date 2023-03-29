package com.masai.dto;

import java.util.Date;
import java.util.Objects;

import lombok.Data;

public class MemberUpdateDTO {
	
	private String name;
	
	private Date dob;
	
	private Gender gender;
	
	private String city;
	
	private String state;

	
	public MemberUpdateDTO() {
		// TODO Auto-generated constructor stub
	}


	public MemberUpdateDTO(String name, Date dob, Gender gender, String city, String state) {
		super();
		this.name = name;
		this.dob = dob;
		this.gender = gender;
		this.city = city;
		this.state = state;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}


	public Gender getGender() {
		return gender;
	}


	public void setGender(Gender gender) {
		this.gender = gender;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	@Override
	public int hashCode() {
		return Objects.hash(city, dob, name, state);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemberUpdateDTO other = (MemberUpdateDTO) obj;
		return Objects.equals(city, other.city) && Objects.equals(dob, other.dob) && Objects.equals(name, other.name)
				&& Objects.equals(state, other.state);
	}


	@Override
	public String toString() {
		return "MemberUpdateDTO [name=" + name + ", dob=" + dob + ", city=" + city + ", state=" + state + "]";
	}
	
	
}
