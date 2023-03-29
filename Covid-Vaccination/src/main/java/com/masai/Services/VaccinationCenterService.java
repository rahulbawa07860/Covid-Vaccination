package com.masai.Services;

import java.util.List;

import com.masai.Exceptions.LoginException;
import com.masai.Exceptions.VaccinationCenterException;
import com.masai.Models.VaccinationCenter;

public interface VaccinationCenterService {
	
public List<VaccinationCenter> getAllVaccivationCenters( String key )throws LoginException ,VaccinationCenterException;
	
	public VaccinationCenter getVaccinationCenterById( String key, Integer id)throws LoginException , VaccinationCenterException;
	
	public VaccinationCenter addNewVaccinationCenter( String key, VaccinationCenter center) throws LoginException , VaccinationCenterException;
	
	public VaccinationCenter updateVaccinationCenter( String key , VaccinationCenter center) throws LoginException , VaccinationCenterException;
	
	public Boolean deleteVaccinationCenter( String key , Integer id) throws LoginException , VaccinationCenterException;
	
	

}
