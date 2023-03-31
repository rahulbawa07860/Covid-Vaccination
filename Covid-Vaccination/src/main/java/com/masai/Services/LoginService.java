package com.masai.Services;

import com.masai.Exceptions.AdminException;
import com.masai.Exceptions.LoginException;
import com.masai.Models.User;

public interface LoginService {
	
	public String login(User user) throws LoginException, AdminException;
	
	public String logout(String key, String role) throws LoginException;

}
