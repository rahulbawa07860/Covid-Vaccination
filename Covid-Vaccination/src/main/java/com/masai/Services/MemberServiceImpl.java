package com.masai.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exceptions.MemberException;
import com.masai.Models.Member;
import com.masai.Repository.MemberRepo;
import com.masai.dto.MemberUpdateDTO;

@Service
public class MemberServiceImpl implements MemberServices{

	@Autowired
	private VaccineRegistrationRepo vrr;
	
	@Autowired
	private CurrentUserSessionRepo cusr;
	
	@Autowired
	private IdCardRepo icr;
	
	@Autowired
	private MemberRepo mr;
	
	
	@Override
	public Member getMemberById(String key, int Id) throws LoginException, MemberException {
		// TODO Auto-generated method stub
		CurrentUserSession cus = cusr.findByUuid(key);
		
		if(cus==null) throw new LoginException("Please loging first");
		
		Optional<Member> member = mr.findById(Id);
		
		if(member==null) throw new MemberException("No member found with id: "+Id);
		
		return member.get();
	}

	@Override
	public Member getMemberByAadharNo(Long aadharNo) throws MemberException {
		// TODO Auto-generated method stub
		Member member = mr.findByAadharCardNo(aadharNo);
		
		if(member==null) throw new MemberException("No member found with aadhar number "+aadharNo);
		
		
		return member;
	}

	@Override
	public Member getMemberByPanNo(String panNo) throws MemberException {
		// TODO Auto-generated method stub
		Member member = mr.findByPanNo(panNo);
		
		if(member==null) throw new MemberException("No member found with PAN "+panNo);
		
		return member;
	}

	@Override
	public Member addMember(Member member) throws MemberException {
		// TODO Auto-generated method stub
		if(member==null) throw new MemberException("Please enter a valid member");
		
		return mr.save(member);
	}

	

	@Override
	public boolean deleteMember(String key, int Id) {
		// TODO Auto-generated method stub
		Boolean flag = false;
		
		CurrentUserSession cus = cusr.findByUuid(key);
		
		if(cus==null) throw new LoginException("Please loging first");
		
		Optional<Member> member = mr.findById(Id);
		
		if(member==null) throw new MemberException("Please enter a valid member ID");
		
		mr.deleteById(Id);
		
		flag = true;
		
		return flag;
	}

	@Override
	public Member updateMember(String key, Integer cardId, MemberUpdateDTO memberdto) throws LoginException, IdCardException, MemberException {
		// TODO Auto-generated method stub
		CurrentUserSession cus = cusr.findByUuid(key);
		
		if(cus==null) throw new LoginException("Please loging first");
		
		Optional<Member> member = mr.findById(cardId);
		
		if(member==null) throw new MemberException("No member with cardId "+cardId);
		
		member.get().getIdCard().setName(MemberUpdateDTO.getName());
		member.get().getIdCard().setAddress(MemberUpdateDTO.getAddress());
		member.get().getIdCard().setCity(MemberUpdateDTO.getCity());
		member.get().getIdCard().setDateOfBirth(MemberUpdateDTO.getDateOfBirth());
		member.get().getIdCard().setGender(MemberUpdateDTO.getGender());
		member.get().getIdCard().setState(MemberUpdateDTO.getState());
		
		mr.save(member.get());
		return member.get();
	}

}