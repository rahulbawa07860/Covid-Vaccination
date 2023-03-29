package com.masai.dto;

import java.util.Date;
import java.util.Objects;

import com.masai.Enums.Gender;

import lombok.Data;

public class MemberUpdateDTO {
	
	private String name;
	
	private Date dobDateOfBirth ;
	
	private Gender gender;
	
	private String city;
	
	private String state;

	private String Address ;

	public MemberUpdateDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MemberUpdateDTO(String name, Date dobDateOfBirth, Gender gender, String city, String state, String address) {
		super();
		this.name = name;
		this.dobDateOfBirth = dobDateOfBirth;
		this.gender = gender;
		this.city = city;
		this.state = state;
		Address = address;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Address, city, dobDateOfBirth, gender, name, state);
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
		return Objects.equals(Address, other.Address) && Objects.equals(city, other.city)
				&& Objects.equals(dobDateOfBirth, other.dobDateOfBirth) && gender == other.gender
				&& Objects.equals(name, other.name) && Objects.equals(state, other.state);
	}

	@Override
	public String toString() {
		return "MemberUpdateDTO [name=" + name + ", dobDateOfBirth=" + dobDateOfBirth + ", gender=" + gender + ", city="
				+ city + ", state=" + state + ", Address=" + Address + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDobDateOfBirth() {
		return dobDateOfBirth;
	}

	public void setDobDateOfBirth(Date dobDateOfBirth) {
		this.dobDateOfBirth = dobDateOfBirth;
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

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	
	
	
	
}
