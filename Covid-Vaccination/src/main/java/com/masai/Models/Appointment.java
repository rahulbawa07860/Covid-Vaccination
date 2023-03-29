package com.masai.Models;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.Setter;

@Data
@Entity

public class Appointment {

	private Integer bookingId;
	private String mobileNo;
	
}
