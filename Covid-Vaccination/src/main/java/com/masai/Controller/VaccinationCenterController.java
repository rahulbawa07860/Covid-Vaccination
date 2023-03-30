package com.masai.Controller;

import java.util.List;

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

import com.masai.Exceptions.LoginException;
import com.masai.Exceptions.VaccinationCenterException;
import com.masai.Models.VaccinationCenter;
import com.masai.Services.VaccinationCenterService;

@RestController
@RequestMapping("/VaccinCenter")

public class VaccinationCenterController {
	@Autowired
	private VaccinationCenterService centerService;
	
	
	//***********************  Controller for addNew Vaccination Center  ******************************//
	@PostMapping("/AddNewCenter")
	public ResponseEntity<VaccinationCenter> addNewVaccinationCenterHandler( @RequestParam("key") String key, @RequestBody VaccinationCenter center ) 
	                                         throws
	LoginException, VaccinationCenterException{
		VaccinationCenter savedCenter = centerService.addNewVaccinationCenter(key, center);
		return new ResponseEntity<>(savedCenter, HttpStatus.CREATED);
	}
	
	//***********************  Controller for get Vaccination Center ******************************//
	@GetMapping("/GetCenter")
	public ResponseEntity<VaccinationCenter> getVaccinationCenterHandler( @RequestParam("key") String key, @RequestParam("id") Integer id) 
	                                         throws
	LoginException, VaccinationCenterException{
        VaccinationCenter savedCenter = centerService.getVaccinationCenterById(key, id);
		return new ResponseEntity<>(savedCenter, HttpStatus.CREATED);
	}
	
	//***********************  Controller for getAll Vaccination Center  ******************************//
	@GetMapping("/GetAllCenters")
	public ResponseEntity<List<VaccinationCenter>> getAllVaccinationCenterHandler( @RequestParam("key") String key ) 
	                                         throws
	LoginException, VaccinationCenterException{
		List<VaccinationCenter> centers = centerService.getAllVaccivationCenters(key);
		return new ResponseEntity<>(centers, HttpStatus.CREATED);
		
	}
	
	//***********************  Controller for update Vaccination Center ******************************//
	@PutMapping("/UpdateCenter")
    public ResponseEntity<VaccinationCenter> updateVaccinationCenterHandler( @RequestParam("key") String key, @RequestBody VaccinationCenter center )
                                             throws
    LoginException, VaccinationCenterException{
		VaccinationCenter savedCenter = centerService.updateVaccinationCenter(key, center);
		return new ResponseEntity<>(savedCenter, HttpStatus.CREATED);
    }
	
	//***********************  Controller for delete Vaccination Center ******************************//
	@DeleteMapping("/DeleteCenter")
    public ResponseEntity<Boolean> deleteVaccinationCenterHandler( @RequestParam("key") String key, @RequestParam("id") Integer id) 
                                             throws 
    LoginException, VaccinationCenterException{
		Boolean status = centerService.deleteVaccinationCenter(key, id);
		return new ResponseEntity<>(status, HttpStatus.CREATED);
	}
}
