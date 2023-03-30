package com.masai.Services;

import java.util.List;

import com.masai.Exceptions.LoginException;
import com.masai.Exceptions.VaccineException;
import com.masai.Models.Vaccine;

public interface VaccineService {
	
	public Vaccine addVaccine(String key,Vaccine v) throws LoginException;
	public List<Vaccine> allVaccines(String key) throws LoginException,VaccineException;
	public Vaccine getVaccineByName(String key,String name) throws LoginException,VaccineException;
	public Vaccine getVaccineById(String key,Integer id) throws LoginException,VaccineException;
	public Vaccine updateVaccine(String key,Integer id,Vaccine v) throws LoginException,VaccineException;
	public Boolean deleteVaccine(String key,Integer id) throws LoginException, VaccineException; 


}
