package com.masai.Services;

import com.masai.Models.Admin;
import com.masai.Exceptions.AdminException;
import com.masai.Exceptions.LoginException;

public interface AdminService {
	
	public Admin registerAdmin(Admin admin) throws AdminException;
	
	public String deleteAdmin(String key) throws AdminException, LoginException;

}
