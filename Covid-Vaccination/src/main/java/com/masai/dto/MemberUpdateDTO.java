package com.masai.dto;

import java.util.Date;

import lombok.Data;

@Data
public class MemberUpdateDTO {
	
	private String name;
	
	private Date dob;
	
	private Gender gender;
	
	private String city;
	
	private String state;

}
