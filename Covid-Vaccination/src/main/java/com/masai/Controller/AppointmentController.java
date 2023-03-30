package com.masai.Controller;

import java.util.List;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exceptions.AppointmentException;
import com.masai.Exceptions.MemberException;
import com.masai.Exceptions.VaccinationCenterException;
import com.masai.Exceptions.VaccineInventoryException;
import com.masai.Exceptions.VaccineRegistrationException;
import com.masai.Models.Appointment;
import com.masai.Services.AppointmentService;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;
	
	
	@PostMapping("/bookAppointment")
	public ResponseEntity<Appointment> RegisterNewAppointmentHandler(@RequestParam("key") String key, @RequestParam("aadharNo") String aadharNo, @RequestParam("centerCode") Integer centerCode , @RequestBody Appointment appointment)throws LoginException, AppointmentException, MemberException, VaccinationCenterException, VaccineRegistrationException, VaccineInventoryException
	{
		Appointment enterAppointment = appointmentService.addAppointment(key, appointment, aadharNo, centerCode);
		return new ResponseEntity<>(enterAppointment, HttpStatus.CREATED);
	}
	@GetMapping("/getAppointment")
	public ResponseEntity<Appointment> getAppointmentHandler(@RequestParam("key") String key, @RequestParam("aadharNo") String aadharNo ) throws AppointmentException, LoginException
	{
		Appointment enterAppointment = appointmentService.getAppointment(key, aadharNo);
		return new ResponseEntity<>(enterAppointment, HttpStatus.OK);
	}
	
	@GetMapping("/getAppointments")
	public ResponseEntity<List<Appointment>> getAppointmentHandler(@RequestParam("key") String key) throws AppointmentException, LoginException
	{
		List<Appointment> enterAppointments = appointmentService.getAllAppointments(key);
		return new ResponseEntity<>(enterAppointments, HttpStatus.OK);
	}
	
	@PutMapping("/UpdateAppointment")
	public ResponseEntity<Appointment> updateAppointmentHandler(@RequestParam("key") String key, @RequestParam("aadharNo") String aadharNo, @RequestBody Appointment appointment  ) throws AppointmentException, LoginException
	{
		Appointment enterAppointment =  appointmentService.updateAppointment(key, aadharNo, appointment);
		return new ResponseEntity<>(enterAppointment, HttpStatus.OK);
	}
	
	@DeleteMapping("/DeleteAppointment")
	public ResponseEntity<Boolean> deleteApppointmentHandler(@RequestParam("key") String key, @RequestParam("aadharNo") String aadharNo ) throws AppointmentException, LoginException
	{
		Boolean result =  appointmentService.deleteAppointment(key, aadharNo);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
}
