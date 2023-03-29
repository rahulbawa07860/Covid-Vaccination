package com.masai.Services;
import java.time.LocalDate;
import java.util.List;

import com.masai.Exceptions.LoginException;
import com.masai.Exceptions.VaccineInventoryException;
import com.masai.Models.VaccineInventory;
public interface VaccineInventoryService {
	public VaccineCount addVaccineCount(String key,Integer inId,Vaccine v,Integer qty) throws LoginException,VaccineInventoryException; 
	public List<VaccineInventory> getInventoryByDate(String key,LocalDate date)throws LoginException;
	public VaccineInventory addInventory(String key,VaccineInventory inventory)throws LoginException,VaccinationCenterException;
	public VaccineInventory getInventoryByVaccinationCenter(String key,Integer id) throws LoginException,VaccinationCenterException;
	public List<VaccineCount> getVaccineCountByCenter(String key,VaccineInventory in)throws LoginException,VaccineInventoryException;
	public List<VaccineInventory> getAllVaccineInventories(String key) throws LoginException;
}
