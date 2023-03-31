package com.masai.Models;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.masai.Enums.Gender;

import jakarta.persistence.*;




@Entity
public class IdCard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	
	@NotEmpty(message = "Name is mandatory")
	@Size(min = 3, max = 20, message = "Name length should be of size 3-20")
	private String Name;
	
	@Past
	private LocalDate DateOfBirth ;
	
	@NotNull(message = "Gender can't be null")
	@Enumerated
	private Gender gender;
	
	@NotEmpty(message =  "Address is mandatory")
	private String Address ;
	
	@NotEmpty(message =  "City is mandatory")
	@Size(min = 2, max = 30 , message = "City length should be of size 3-20")
	private String city ;
	
	@NotEmpty(message =  "State is mandatory")
	@Size(min = 2, max = 30 , message = "State length should be of size 3-20")
	private String State ;
	
	@OneToOne(cascade = CascadeType.ALL)
	private PanCard panCard;
	@OneToOne(cascade = CascadeType.ALL)
	private AdharCard adharCard;
	

	
	@OneToOne(cascade = CascadeType.ALL)
	private Member member;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public LocalDate getDateOfBirth() {
		return DateOfBirth;
	}

	public void setDateOfBirth(LocalDate date) {
		DateOfBirth = date;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public PanCard getPanCard() {
		return panCard;
	}

	public void setPanCard(PanCard panCard) {
		this.panCard = panCard;
	}

	public AdharCard getAdharCard() {
		return adharCard;
	}

	public void setAdharCard(AdharCard adharCard) {
		this.adharCard = adharCard;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public IdCard() {
		
		// TODO Auto-generated constructor stub
	}

	public IdCard(Integer id,
			@NotEmpty(message = "Name is mandatory") @Size(min = 3, max = 20, message = "Name length should be of size 3-20") String name,
			LocalDate dateOfBirth, @NotNull(message = "Gender can't be null") Gender gender,
			@NotEmpty(message = "Address is mandatory") String address,
			@NotEmpty(message = "City is mandatory") @Size(min = 2, max = 30, message = "City length should be of size 3-20") String city,
			@NotEmpty(message = "State is mandatory") @Size(min = 2, max = 30, message = "State length should be of size 3-20") String state,
			PanCard panCard, AdharCard adharCard, Member member) {
		super();
		Id = id;
		Name = name;
		DateOfBirth = dateOfBirth;
		this.gender = gender;
		Address = address;
		this.city = city;
		State = state;
		this.panCard = panCard;
		this.adharCard = adharCard;
		this.member = member;
	}

	@Override
	public String toString() {
		return "IdCard [Id=" + Id + ", Name=" + Name + ", DateOfBirth=" + DateOfBirth + ", gender=" + gender
				+ ", Address=" + Address + ", city=" + city + ", State=" + State + ", panCard=" + panCard
				+ ", adharCard=" + adharCard + ", member=" + member + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Address, DateOfBirth, Id, Name, State, adharCard, city, gender, member, panCard);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IdCard other = (IdCard) obj;
		return Objects.equals(Address, other.Address) && Objects.equals(DateOfBirth, other.DateOfBirth)
				&& Objects.equals(Id, other.Id) && Objects.equals(Name, other.Name)
				&& Objects.equals(State, other.State) && Objects.equals(adharCard, other.adharCard)
				&& Objects.equals(city, other.city) && gender == other.gender && Objects.equals(member, other.member)
				&& Objects.equals(panCard, other.panCard);
	}
	
	
	
//	{
//		   "name": "Ankush",
//		   "dateOfBirth": "1999-12-24",
//		   "gender": "Male",
//		   "address":"India",
//		   "city": "Ara",
//		   "state": "Bihar",
//		   "panCard": {
//		       "panNo": "1234567890"
//
//		   },
//		   "adharCard": {
//		       "adharNo": "123423453456",
//		       "fingerprints": "Present",
//		       "irisscan": "Present"
//		   }
//		}

	
	
	
	
	
	

}
