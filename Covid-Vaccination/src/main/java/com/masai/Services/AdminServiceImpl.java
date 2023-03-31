package com.masai.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exceptions.AdminException;
import com.masai.Exceptions.LoginException;
import com.masai.Models.Admin;
import com.masai.Models.CurrentAdminUserSession;
import com.masai.Repository.AdminRepo;
import com.masai.Repository.CurrentAdminUserSessionRepo;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminRepo adminRepo;
	
	@Autowired
	private CurrentAdminUserSessionRepo adminUserSessionRepo;

	@Override
	public Admin registerAdmin(Admin admin) throws AdminException {
		// TODO Auto-generated method stub
		Admin a = adminRepo.findByEmail(admin.getEmail());
		
		if(a!=null) throw new AdminException("Admin already exists");
		
		if(admin.getPassword().equals(admin.getConfirmPassword())) {
			adminRepo.save(admin);
			return admin;
		}else {
			throw new AdminException("Password doesn't match");
		}
		
		
		
	}

	@Override
	public String deleteAdmin(String key) throws AdminException, LoginException {
		// TODO Auto-generated method stub
		
		CurrentAdminUserSession adminUserSession = adminUserSessionRepo.findByUuid(key);
		
		if(adminUserSession==null) throw new LoginException("Admin not logged in");
		
		Admin admin = adminRepo.findByAdminId(adminUserSession.getAdminId());
		
		if(admin==null) throw new AdminException("Admin doesnot exist");
		
		adminRepo.delete(admin);
		
		return "Admin deleted";
	}
	
	

}
