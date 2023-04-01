package com.masai.Models;

import com.masai.Enums.Role;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class User {
	
	public String email;
	public String password;
	
	@Enumerated(EnumType.STRING)
	public Role role;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String email, String password, Role role) {
		super();
		this.email = email;
		this.password = password;
		this.role = role;
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + ", role=" + role + "]";
	}
	
	

}
