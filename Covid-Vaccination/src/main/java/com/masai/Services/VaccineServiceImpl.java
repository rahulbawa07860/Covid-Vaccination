package com.masai.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Repository.VaccineRepository;
import com.masai.Exceptions.LoginException;
import com.masai.Exceptions.VaccineException;
import com.masai.Models.Vaccine;

public class VaccineServiceImpl implements VaccineService{
	
	@Autowired
	private CurrentUserRepo cuRepo;
	
	@Autowired
	private VaccineRepository vaccineRepo;

	@Override
	public Vaccine addVaccine(String key, Vaccine v) throws LoginException {
		if(cuRepo.findByUuid(key)!=null) {
			return vaccineRepo.save(v);
		}else {
			throw new LoginException("Please login as an admin first ");
		}
	}

	@Override
	public List<Vaccine> allVaccines(String key) throws LoginException, VaccineException {
		if(cuRepo.findByUuid(key)!=null) {
			List<Vaccine> list=vaccineRepo.findAll();
			if(list.size()!=0) {
				return list;
			}else {
				throw new VaccineException("Sorry, Vaccine Not Found");
			}
		}else {
			throw new LoginException("Please login as an admin first ");
		}
	}

	@Override
	public Vaccine getVaccineByName(String key, String name) throws LoginException, VaccineException {
		if(cuRepo.findByUuid(key)!=null) {
			Vaccine v= vaccineRepo.findByName(name);
			if(v==null) {
				throw new VaccineException("Sorry, Vaccine Not Found");
			}else {
				return v;
			}
		}else {
			throw new LoginException("Please login as admin first ");
		}
	}

	@Override
	public Vaccine getVaccineById(String key, Integer id) throws LoginException, VaccineException {
		if(cuRepo.findByUuid(key)!=null) {
			return vaccineRepo.findById(id).orElseThrow(()->new VaccineException("Sorry, Vaccine Not Found"));
		}else {
			throw new LoginException("Please login as an admin first ");
		}
	}

	@Override
	public Vaccine updateVaccine(String key, Integer id, Vaccine v) throws LoginException, VaccineException {
		if(cuRepo.findByUuid(key)!=null) {
			Vaccine vaccine=vaccineRepo.findById(id).orElseThrow(()->new VaccineException("Sorry, Vaccine Not Found"));
			vaccine.setVaccineName(v.getVaccineName());
			vaccine.setDescription(v.getDescription());
			return vaccineRepo.save(vaccine);
		}else {
			throw new LoginException("Please login as admin first ");
		}
	}

	@Override
	public Boolean deleteVaccine(String key, Integer id) throws LoginException, VaccineException {
		if(cuRepo.findByUuid(key)!=null) {
			Vaccine vaccine=vaccineRepo.findById(id).orElseThrow(()->new VaccineException("Sorry, Vaccine Not Found"));
			if(vaccine!=null) {
				vaccineRepo.delete(vaccine);
				return true;
			}else {
				return false;
			}
		}else {
			throw new LoginException("Please login as an admin first ");
		}
	}
	

}
