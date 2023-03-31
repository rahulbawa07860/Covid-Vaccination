package com.masai.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exceptions.LoginException;
import com.masai.Exceptions.VaccinationCenterException;
import com.masai.Models.CurrentAdminUserSession;
import com.masai.Models.CurrentMemberUserSession;
import com.masai.Models.VaccinationCenter;
import com.masai.Repository.CurrentAdminUserSessionRepo;
import com.masai.Repository.CurrentMemberUserSessionRepo;
import com.masai.Repository.VaccinationCenterRepository;
import com.masai.Repository.VaccineInventoryRepository;


@Service
public class VaccinationCenterServiceImpl implements VaccinationCenterService{
	
	@Autowired
	private CurrentMemberUserSessionRepo SessRepo;
	
	@Autowired
	private CurrentAdminUserSessionRepo AessRepo;
	
	@Autowired
	private VaccinationCenterRepository vaccineCenterRepo;
	
	
	@Autowired
	private VaccineInventoryRepository inventoryRepo; 
	
	
	

	//********************************* Implementation for  Get All VaccivationCenters Here *******************************//
	
	@Override
	public List<VaccinationCenter> getAllVaccivationCenters(String key)	throws LoginException, VaccinationCenterException {
		
		// First we will check logging status here.
		CurrentMemberUserSession cusession = SessRepo.findByUuid(key);
		// if Logging OK
		if(cusession != null) {
			//if user is member or admin;
			
				List <VaccinationCenter> centers = vaccineCenterRepo.findAll();
				
				// check if center is not empty the.
				if(! centers.isEmpty()) {
					return centers;
				}else {
					throw new VaccinationCenterException("No vaccination center avilable here");
				}
				
				
			
			
		}else {
			throw new LoginException("Please Loging First !!!!");
		}
		
	}
	
	
	
	
	//********************************* Implementation for  Get All VaccivationCenters By Id *******************************//
	@Override
	public VaccinationCenter getVaccinationCenterById(String key, Integer id) throws LoginException, VaccinationCenterException {
		
	   // First we will check logging status here.
		CurrentMemberUserSession cusession = SessRepo.findByUuid(key);
		//if logged In then
		if(cusession != null) {
			Optional<VaccinationCenter> opt = vaccineCenterRepo.findById(id);
			//If vaccination center  is present.
			if(opt.isPresent()) {
				return opt.get();
			}else {
				throw new VaccinationCenterException("Vaccination center not avilable here");
			}
			
			
		}else {
			throw new LoginException("Please Login First");
		}
	}
	
	
	
	
	
	
	//********************************* Implementation for Add New VaccivationCenters  ************************************//
	@Override
	public VaccinationCenter addNewVaccinationCenter(String key, VaccinationCenter center) throws LoginException, VaccinationCenterException {
	    
		   // First we will check logging status here.
		CurrentAdminUserSession cusession = AessRepo.findByUuid(key);
		if(cusession != null) {
			//if user is admin or member
			return vaccineCenterRepo.save(center);
				
		}else {
			throw new LoginException("Please Login as admin first!");
		}
		
		
	}
	
	
	
	
	
	//********************************* Implementation for Update VaccivationCenters  ************************************//
	@Override
	public VaccinationCenter updateVaccinationCenter(String key, VaccinationCenter center) throws LoginException, VaccinationCenterException {
		
		  // First we will check logging status here.
			CurrentAdminUserSession cusession = AessRepo.findByUuid(key);
			//if logged In then
			if(cusession != null) {
				// if user is admin or member;
				
					
					Optional<VaccinationCenter> opt = vaccineCenterRepo.findById(center.getCenterCode());
					if(opt.isPresent()) {
						VaccinationCenter savedCenter = opt.get();
						savedCenter.setAddress(center.getAddress());
						savedCenter.setAppointments(center.getAppointments());
						savedCenter.setName(center.getName());
						savedCenter.setInventory(center.getInventory());
						
						return vaccineCenterRepo.save(savedCenter);
					}else {
						throw new VaccinationCenterException("No any vacination center here!!!");
					}
					
				
			}else {
				throw new LoginException("please Login First");
			}
			
	}
	
	
	
	
	
	//********************************* Implementation for Delete VaccivationCenters  ************************************//

	@Override
	public Boolean deleteVaccinationCenter(String key, Integer id) throws LoginException, VaccinationCenterException {
		
		 // First we will check logging status here.
		CurrentAdminUserSession cusession = AessRepo.findByUuid(key);
		//if logged In then
		if(cusession != null) {
			// if user is admin or member;
			
				Optional<VaccinationCenter> opt = vaccineCenterRepo.findById(id);
				if (opt.isPresent()) {
					VaccinationCenter center = opt.get();
					vaccineCenterRepo.delete(center);
					return true;
					
				}else {
					throw new VaccinationCenterException("No Vaccination center found");
				}
				
			
			
		}else {
			throw new LoginException("Please Login first");
		}
		
	}

}
