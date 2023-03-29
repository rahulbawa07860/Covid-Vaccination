package com.masai.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exceptions.LoginException;
import com.masai.Models.VaccineInventory;
import com.masai.Services.VaccineInventoryService;

@RestController("/inventory")
public class VaccineInventoryController {
    @Autowired
	private VaccineInventoryService vaccineInventoryService;
	@Autowired
	private VaccinationCenterService vaccinationCenterService;
	@Autowired
	private VaccineServices vaccineService;
	
	@PostMapping("addInventory")
	public ResponseEntity<VaccineInventory> addNewInventory(@RequestParam("key") String key,@RequestBody VaccineInventory i) throws LoginException, VaccinationCenterException{
		VaccineInventory saved=vaccineInventoryService.addInventory(key, i);
		return new ResponseEntity<>(saved,HttpStatus.CREATED);
	}
	
	@PostMapping("/addVaccineCount/{CenterId}/{vaccineName}/{quantity}")
	public ResponseEntity<VaccineCount> addVacccineCount(@RequestParam("key") String key,@RequestParam Integer CenterId,@RequestParam String vaccineName ,@RequestParam Integer quantity) throws VaccineInventoryException, VaccineException, LoginException, VaccinationCenterException{
		Vaccine v = vaccineService.getVaccineByName(key, vaccineName);
		VaccinationCenter c=vaccinationCenterService.getVaccinationCenterById(key, CenterId);
		VaccineCount count=vaccineInventoryService.addVaccineCount(key, c.getInventory().getInventoryId(), v, quantity);
		return new ResponseEntity<>(count,HttpStatus.CREATED);
	}
	
	@GetMapping("/getInventory/{CenterID}")
	public ResponseEntity<List<VaccineCount>> getVaccineCountByCenter(@RequestParam("key") String key,@RequestParam Integer CenterID) throws LoginException, VaccinationCenterException, VaccineInventoryException{
		VaccineInventory in=vaccineInventoryService.getInventoryByVaccinationCenter(key, CenterID);
		List<VaccineCount> count=vaccineInventoryService.getVaccineCountByCenter(key, in);
		return new ResponseEntity<>(count,HttpStatus.FOUND);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<VaccineInventory>> getAllInventories(@RequestParam("key") String key) throws LoginException
	{
		List<VaccineInventory> list = vaccineInventoryService.getAllVaccineInventories(key);
		return new ResponseEntity<>(list, HttpStatus.FOUND);
	}
	
	@GetMapping("/getByDate/{date}")
	public ResponseEntity<List<VaccineInventory>> getInventoriesByDate(@RequestParam("key") String key,@RequestParam String date) throws LoginException{
		List<VaccineInventory> list = vaccineInventoryService.getInventoryByDate(key, LocalDate.parse(date));
		return new ResponseEntity<>(list,HttpStatus.FOUND);
	}
	
	@GetMapping("/getById/{centerID}")
	public ResponseEntity<VaccineInventory> getVacineInventoryByCenter(@RequestParam("key") String key,@RequestParam Integer centerID) throws VaccinationCenterException, LoginException{
		VaccineInventory inventory=vaccineInventoryService.getInventoryByVaccinationCenter(key, centerID);
		return new ResponseEntity<>(inventory,HttpStatus.FOUND);
	}
	
}
