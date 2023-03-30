package com.masai.dto;

import java.time.LocalDate;
import java.util.Objects;

import javax.validation.constraints.Size;

import com.masai.Enums.Gender;

public class MemberUpdateDTO {
	
	@Size(min = 2, max = 20, message = "{user.invalid.Name}")
	private String name;
	
	private LocalDate DateOfBirth ;

	
	private Gender gender;
	
	@Size(min = 2, max = 20, message = "{user.invalid.City}")
	private String city;
	
	@Size(min = 2, max = 20, message = "{user.invalid.State}")
	private String state;

	@Size(min = 2, max = 20, message = "{user.invalid.Address}")
	private String Address ;

	public MemberUpdateDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MemberUpdateDTO(String name, LocalDate DateOfBirth, Gender gender, String city, String state, String address) {
		super();
		this.name = name;
		this.DateOfBirth = DateOfBirth;
		this.gender = gender;
		this.city = city;
		this.state = state;
		Address = address;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Address, city, DateOfBirth, gender, name, state);
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
				&& Objects.equals(DateOfBirth, other.DateOfBirth) && gender == other.gender
				&& Objects.equals(name, other.name) && Objects.equals(state, other.state);
	}

	@Override
	public String toString() {
		return "MemberUpdateDTO [name=" + name + ", dobDateOfBirth=" + DateOfBirth + ", gender=" + gender + ", city="
				+ city + ", state=" + state + ", Address=" + Address + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDobDateOfBirth() {
		return DateOfBirth;
	}

	public void setDobDateOfBirth(LocalDate dobDateOfBirth) {
		this.DateOfBirth = dobDateOfBirth;
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
