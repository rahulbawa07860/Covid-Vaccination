package com.masai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exceptions.AdharCardException;
import com.masai.Exceptions.IdCardException;
import com.masai.Exceptions.PanCardException;
import com.masai.Models.IdCard;
import com.masai.Services.IdCardService;

@RestController
@RequestMapping("/idCards")
public class IdCardController {
	
	@Autowired
	private IdCardService idservice;
	
	@PostMapping("/register")
	public ResponseEntity<IdCard> RegisterIdCardHandler(@RequestBody IdCard idcard) throws IdCardException {
		
		IdCard card = idservice.addIdCard(idcard);
		return new ResponseEntity<IdCard>(card,HttpStatus.OK);
	}
	
	@GetMapping("/getIdByAdhar/{adharnumber}")
	public ResponseEntity<IdCard> getIdCardByAdharNumber(@PathVariable String adharnumber) throws IdCardException, AdharCardException{
		
		IdCard card = idservice.findIdCardByAdharNo(adharnumber);
		return new ResponseEntity<IdCard>(card,HttpStatus.OK);
		
		
	}
	
	
	@GetMapping("/getIdBypan/{pannumber}")
	public ResponseEntity<IdCard> getIdCardByPanNumber(@PathVariable String pannumber) throws IdCardException,PanCardException{
		
		IdCard card = idservice.findIdCardBypanNo(pannumber);
		return new ResponseEntity<IdCard>(card,HttpStatus.OK);
	}

}
