package com.masai.Services;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exceptions.LoginException;
import com.masai.Exceptions.VaccinationCenterException;
import com.masai.Exceptions.VaccineInventoryException;
import com.masai.Models.VaccinationCenter;
import com.masai.Models.VaccineInventory;
import com.masai.Repository.VaccinationCenterRepository;
import com.masai.Repository.VaccineInventoryRepository;

@Service
public class VaccineInventoryServiceImpl implements VaccineInventoryService{
    @Autowired
	private CurrentUserSessionRepo currentUserSessRepo;
    @Autowired
	private VaccineInventoryRepository vaccineInventoryRepo;
	@Autowired
	private VaccineCountRepository vaccineCountRepo;
	@Autowired
	private VaccinationCenterRepository vaccinationCenterRepo;
	@Override
	public VaccineCount addVaccineCount(String key, Integer inId, Vaccine v, Integer qty) throws LoginException, VaccineInventoryException {
		// TODO Auto-generated method stub
		if(currentUserSessRepo.findByUuid(key)!=null)
		{
			VaccineInventory inventory=vaccineInventoryRepo.findById(inId).orElseThrow(()-> new VaccineInventoryException("sInventory Not Found"));
			List<VaccineCount> counts= vaccineCountRepo.findByInventory(inventory).stream().filter(count->count.getVaccine().equals(v)).collect(Collectors.toList());
		    if(counts.size()==0)
		    {
		    	VaccineCount c = new VaccineCount();
		    	c.setVaccine(v);
		    	c.setQuantity(qty);
		    	c.setInId(inId);
		    	c.setInventory(inventory);
		    	VaccineCount eneter = vaccineCountRepo.save(c);
		    	VaccineInventory enetered = vaccineInventoryRepo.save(inventory);
		    	return enetered;
		    	
		    }
		    else {
				counts.get(0).setQuantity(counts.get(0).getQuantity()+qty);
				VaccineCount eneter = vaccineCountRepo.save(counts.get(0));
				VaccineInventory enetered = vaccineInventoryRepo.save(inventory);
				return enetered;
			}
		}else {
			throw new LoginException("Login as Admin please");
		}
	}
	
	@Override
	public List<VaccineInventory> getInventoryByDate(String key, LocalDate date) throws LoginException {
		// TODO Auto-generated method stub
		if(currentUserSessRepo.findByUuid(key)!=null)
		{
			return vaccineInventoryRepo.findByDate(date);
			
		}
		else {
			throw new LoginException("Login as Admin please");
		}
	}
	@Override
	public VaccineInventory addInventory(String key, VaccineInventory inventory) throws LoginException, VaccinationCenterException {
		// TODO Auto-generated method stub
		if(currentUserSessRepo.findByUuid(key)!=null)
		{
			return vaccineInventoryRepo.save(inventory);
			
		}
		else {
			throw new LoginException("Login as Admin please");
		}
	}
	@Override
	public VaccineInventory getInventoryByVaccinationCenter(String key, Integer id) throws LoginException, VaccinationCenterException {
		// TODO Auto-generated method stub
		if(currentUserSessRepo.findByUuid(key)!=null)
		{
			VaccinationCenter vaccinationCenter = vaccinationCenterRepo.findById(id).orElseThrow(()-> new VaccinationCenterException("Inventory not found"));
			return vaccinationCenter.getInventory();
			
		}
		else {
			throw new LoginException("Login as Admin please");
		}
	}
	@Override
	public List<VaccineCount> getVaccineCountByCenter(String key, VaccineInventory in) throws LoginException, VaccineInventoryException {
		// TODO Auto-generated method stub
				if(currentUserSessRepo.findByUuid(key)!=null)
				{
					List<VaccineCount> list = vaccineCountRepo.findByInventory(in);
					if(list.size()!=0)
					{
						return list;
					}
					else {
						throw new VaccineInventoryException("Inventory is empty");
					}
					
				}
				else {
					throw new LoginException("Login as Admin please");
				}
	}
	@Override
	public List<VaccineInventory> getAllVaccineInventories(String key) throws LoginException {
		// TODO Auto-generated method stub
		if(currentUserSessRepo.findByUuid(key)!=null)
		{
			return vaccineInventoryRepo.findAll();
			
			
		}
		else {
			throw new LoginException("Login as Admin please");
		}
	}
	
	
	
	
	
}
