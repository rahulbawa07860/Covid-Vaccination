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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Models.Vaccine;
import com.masai.Exceptions.LoginException;
import com.masai.Exceptions.VaccineException;
import com.masai.Services.VaccineService;

@RestController

public class VaccineController {
	
	@Autowired
	private VaccineService vaccineservice;
	
	@PostMapping("/newVaccine")
	public ResponseEntity<Vaccine> addVaccine(@RequestParam("key") String key,@RequestBody Vaccine v) throws LoginException{
		Vaccine vaccine=vaccineservice.addVaccine(key, v); 
		return new ResponseEntity<>(vaccine,HttpStatus.CREATED);
	}
	
	@GetMapping("/allVaccines")
	public ResponseEntity<List<Vaccine>> getVaccines(@RequestParam("key") String key) throws LoginException, VaccineException{
		List<Vaccine> list=vaccineservice.allVaccines(key);
		return new ResponseEntity<>(list,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getVaccine/{id}")
	public ResponseEntity<Vaccine> getVaccineById(@RequestParam("key") String key,@RequestParam Integer id) throws VaccineException, LoginException{
		Vaccine vaccine=vaccineservice.getVaccineById(key,id); 
		return new ResponseEntity<>(vaccine,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/updateVaccine/{id}")
	public ResponseEntity<Vaccine> updateVaccineDetails(@RequestParam("key") String key,@RequestParam Integer id,@RequestBody Vaccine v) throws VaccineException, LoginException{
		Vaccine vaccine=vaccineservice.updateVaccine(key,id, v);
		return new ResponseEntity<>(vaccine,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/deleteVaccine/{id}")
	public ResponseEntity<String> deleteVaccine(@RequestParam("key") String key,@RequestParam Integer id) throws VaccineException, LoginException{
		Boolean ans=vaccineservice.deleteVaccine(key, id);
		if(ans) {
			return new ResponseEntity<>("Deleted!",HttpStatus.ACCEPTED);
		}else {
			return new ResponseEntity<>("Vaccine Not Found!",HttpStatus.NOT_FOUND);
		}
		
	}

}
