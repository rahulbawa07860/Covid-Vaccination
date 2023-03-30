package com.masai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Models.Member;
import com.masai.Models.VaccineRegistration;
import com.masai.Exceptions.LoginException;
import com.masai.Exceptions.MemberException;
import com.masai.Exceptions.VaccineRegistrationException;
import com.masai.Services.VaccineRegistrationService;


@RestController
@RequestMapping("/vaccineRegistration")

public class VaccineRegistrationController {
	
	@Autowired
	private VaccineRegistrationService vcRegService;
	
	@PostMapping("/registration")
	public ResponseEntity<VaccineRegistration> addVaccineRegistrationHandler( @RequestParam("key") String key , String aadharNo , @RequestBody VaccineRegistration vr ) throws VaccineRegistrationException, LoginException, MemberException{
		
		VaccineRegistration VaccineRegistration = vcRegService.addVaccineRegistration( key, aadharNo , vr);
		
		return new ResponseEntity<>(VaccineRegistration, HttpStatus.CREATED);
	}
	
	@GetMapping("/registration")
	public ResponseEntity<VaccineRegistration> getVaccineRegistrationByMobNoHandler( @RequestParam("key") String key , @RequestParam("mobNo") String mobNo ) throws VaccineRegistrationException, LoginException{
		
		VaccineRegistration VaccineRegistration = vcRegService.getVaccineRegistrationByMobNo( key, mobNo);
		
		return new ResponseEntity<>(VaccineRegistration, HttpStatus.OK);
	}
	
	@GetMapping("/registrations")
	public ResponseEntity<List<VaccineRegistration>> getAllVaccineRegistrationsHandler( @RequestParam("key") String key ) throws VaccineRegistrationException, LoginException{
		
		List<VaccineRegistration> VaccineRegistrations = vcRegService.getAllVaccineRegistrations( key );
		
		return new ResponseEntity<>(VaccineRegistrations, HttpStatus.OK);
	}
	
	@GetMapping("/registration/members")
	public ResponseEntity<List<Member>> getMembersByMobNoHandler( @RequestParam("key") String key , @RequestParam("mobNo") String mobNo ) throws VaccineRegistrationException, LoginException{
		
		VaccineRegistration VaccineRegistration = vcRegService.getVaccineRegistrationByMobNo( key , mobNo);
		
		return new ResponseEntity<>(VaccineRegistration.getMembers(), HttpStatus.OK);
	}
	
	@PutMapping("/registration")
	public ResponseEntity<VaccineRegistration> updateVaccineRegistrationHandler( @RequestParam("key") String key ,  VaccineRegistration vr ) throws VaccineRegistrationException, LoginException{
		
		VaccineRegistration updateVaccineRegistration = vcRegService.updateVaccineRegistration(key , vr);
		
		return new ResponseEntity<>(updateVaccineRegistration, HttpStatus.OK);
	}
	

}
