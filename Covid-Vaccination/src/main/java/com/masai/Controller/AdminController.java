package com.masai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exceptions.AdminException;
import com.masai.Exceptions.LoginException;
import com.masai.Models.Admin;
import com.masai.Services.AdminService;

@RestController("adminController")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/registerAdmin")
	public ResponseEntity<Admin> registerAdminHanlder(Admin admin) throws AdminException{
		adminService.registerAdmin(admin);
		return new ResponseEntity<Admin>(admin,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteAdmin")
	public ResponseEntity<String> deleteAdminHandler(String key) throws AdminException, LoginException {
		String result = adminService.deleteAdmin(key);
		return new ResponseEntity<String>(result,HttpStatus.OK);
	}

}
