package com.masai.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exceptions.LoginException;
import com.masai.Exceptions.MemberException;
import com.masai.Models.Member;
import com.masai.Services.MemberServices;
import com.masai.dto.MemberUpdateDTO;

@RestController
@RequestMapping("/memberController")
public class MemberController {
	
	@Autowired
	private MemberServices memberServices;
	
	@GetMapping("/member/{key}/{cardId}")
	public ResponseEntity<Member> getMemberByIdHandler(@PathVariable("key") String key, @PathVariable("cardId") Integer cardId) throws LoginException, MemberException {
		Member member = memberServices.getMemberById(key, cardId);
		
		return new ResponseEntity<Member>(member, HttpStatus.OK);
	}
	
	@GetMapping("/getMemberByAadharNo/{key}")
	public ResponseEntity<Member> getMemberByAadharNoHandler(@Valid @PathVariable String key, @RequestParam("aadharNo") String aadharNo) throws MemberException, LoginException {
		Member member = memberServices.getMemberByAadharNo(key,aadharNo);
		
		return new ResponseEntity<Member>(member, HttpStatus.OK);
	}
	
	@GetMapping("/getMemberByPanNo/{key}")
	public ResponseEntity<Member> getMemberByPanNoHandler(@Valid @PathVariable String key, @RequestParam("panNo") String panNo) throws MemberException, LoginException {
		Member member = memberServices.getMemberByPanNo(key,panNo);
		
		return new ResponseEntity<Member>(member, HttpStatus.OK);
	}
	
	@PostMapping("/addMember")
	public ResponseEntity<Member> addmemberHandler(@RequestBody Member member) throws LoginException, MemberException {
		Member m1 = memberServices.addMember(member);
		
		return new ResponseEntity<Member>(m1, HttpStatus.OK);
	}
	
	@PutMapping("/updateMember/{key}/{cardId}")
	public ResponseEntity<Member> updatemember(@PathVariable("key") String key,@PathVariable("cardId") Integer cardId,@RequestBody MemberUpdateDTO memberDto) throws LoginException, MemberException {
		Member m1 = memberServices.updateMember(key, cardId, memberDto);
		
		return new ResponseEntity<Member>(m1, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteMember/{key}/{cardId}")
	public ResponseEntity<Boolean> deleteMemberHandler(@PathVariable("key") String key, @PathVariable("cardId") Integer cardId) throws LoginException, MemberException {
		Boolean bool = memberServices.deleteMember(key, cardId);
		
		return new ResponseEntity<Boolean>(bool, HttpStatus.OK);
	}
	
}
