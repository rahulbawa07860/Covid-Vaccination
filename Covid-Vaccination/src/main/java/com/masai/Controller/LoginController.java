package com.masai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exceptions.AdminException;
import com.masai.Exceptions.LoginException;
import com.masai.Models.User;
import com.masai.Services.LoginService;

@RestController("loginColtroller")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping("/login")
	public ResponseEntity<String> loginHandler(@RequestBody User user) throws LoginException, AdminException {
		String result = loginService.login(user);
		return new ResponseEntity<String>(result,HttpStatus.OK);
	}
	
	@DeleteMapping("/logout")
	public ResponseEntity<String> logoutHandler(@RequestParam String key, @RequestParam String role) throws LoginException {
		String result = loginService.logout(key, role);
		return new ResponseEntity<String>(result,HttpStatus.ACCEPTED);
	}

}
