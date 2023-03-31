package com.masai.Models;

import javax.validation.constraints.Size;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

@Entity
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer adminId;
	
	@Size(max = 20, min = 2)
	@NotEmpty(message = "Name cannot be empty")
	private String name;
	
	@Pattern(regexp="(^$|[0-9]{10})")
	@NotEmpty(message = "Phone cannot be empty")
	private String contactNumber;
	
	@Email
	@NotEmpty(message = "Email cannot be empty")
	private String email;
	
	@Size(max=20, min=6)
	@NotEmpty(message = "Password cannot be empty")
	private String password;
	
	@Size(max=20, min=6)
	@NotEmpty(message = "ConfirmPassword cannot be empty")
	private String confirmPassword;
	
	public Admin() {
		// TODO Auto-generated constructor stub
	}

	public Admin(Integer adminId, String name, String contactNumber, String email, String password,
			String confirmPassword) {
		super();
		this.adminId = adminId;
		this.name = name;
		this.contactNumber = contactNumber;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", name=" + name + ", contactNumber=" + contactNumber + ", email=" + email
				+ ", password=" + password + ", confirmPassword=" + confirmPassword + "]";
	}
	
	

}
