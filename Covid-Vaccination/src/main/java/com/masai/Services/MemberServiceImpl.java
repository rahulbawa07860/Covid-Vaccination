package com.masai.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exceptions.LoginException;
import com.masai.Exceptions.MemberException;
import com.masai.Models.CurrentAdminUserSession;
import com.masai.Models.CurrentMemberUserSession;
import com.masai.Models.IdCard;
import com.masai.Models.Member;
import com.masai.Repository.CurrentAdminUserSessionRepo;
import com.masai.Repository.CurrentMemberUserSessionRepo;
import com.masai.Repository.IdCardRepo;
import com.masai.Repository.MemberRepo;
import com.masai.Repository.VaccineRegistrationRepository;
import com.masai.dto.MemberUpdateDTO;

@Service
public class MemberServiceImpl implements MemberServices{

	@Autowired
	private VaccineRegistrationRepository vaccineRegistrationRepo;
	
	@Autowired
	private CurrentAdminUserSessionRepo cusrAdmin;
	
	@Autowired
	private CurrentMemberUserSessionRepo cusrMember;
	
	@Autowired
	private IdCardRepo idCardRepo;
	
	@Autowired
	private MemberRepo memberRepo;
	
	
	@Override
	public Member getMemberById(String key, Integer cardId) throws MemberException, LoginException {
		// TODO Auto-generated method stub
		CurrentMemberUserSession cusMember = cusrMember.findByUuid(key);
		
		if(cusMember==null) throw new LoginException("Please loging first");
		
		Optional<IdCard> idCard = idCardRepo.findById(cardId);
		
		Optional<Member> member = memberRepo.findByIdCard(idCard);
		
		if(member==null) throw new MemberException("No member found with cardID: "+cardId);
		
		return member.get();
	}

	@Override
	public Member getMemberByAadharNo(String key, String aadharNo) throws MemberException, LoginException {
		// TODO Auto-generated method stub
		CurrentAdminUserSession cusAdmin = cusrAdmin.findByUuid(key);
		
		if(cusAdmin==null) throw new LoginException("Please login first");
		
		Member member = memberRepo.findByAdharcardNo(aadharNo);
		
		if(member==null) throw new MemberException("No member found with aadhar number "+aadharNo);
		
		
		return member;
	}

	@Override
	public Member getMemberByPanNo(String key, String panNo) throws MemberException, LoginException {
		// TODO Auto-generated method stub
		CurrentAdminUserSession cusAdmin = cusrAdmin.findByUuid(key);
		
		if(cusAdmin==null) throw new LoginException("Please login first");
		
		Member member = memberRepo.findByPanNo(panNo);
		
		if(member==null) throw new MemberException("No member found with PAN "+panNo);
		
		return member;
	}

	@Override
	public Member addMember(Member member) throws MemberException {
		// TODO Auto-generated method stub
		if(member==null) throw new MemberException("Please enter a valid member");
		
		return memberRepo.save(member);
	}

	

	@Override
	public boolean deleteMember(String key, Integer cardId) throws MemberException, LoginException {
		// TODO Auto-generated method stub
		Boolean flag = false;
		
		CurrentMemberUserSession cusMember = cusrMember.findByUuid(key);
		
		if(cusMember==null) throw new LoginException("Please loging first");
		
		Optional<IdCard> idCard = idCardRepo.findById(cardId);
		
		Optional<Member> member = memberRepo.findByIdCard(idCard);
		
		if(member==null) throw new MemberException("Please enter a valid member ID");
		
		memberRepo.deleteById(member.get().getMemberId());
		
		flag = true;
		
		return flag;
	}

	@Override
	public Member updateMember(String key, Integer cardId, MemberUpdateDTO memberdto) throws LoginException, MemberException {
		// TODO Auto-generated method stub
		CurrentMemberUserSession cusMember = cusrMember.findByUuid(key);
		
		if(cusMember==null) throw new LoginException("Please loging first");
		
		Optional<IdCard> idCard = idCardRepo.findById(cardId);
		
		Optional<Member> member = memberRepo.findByIdCard(idCard);
		
		if(member==null) throw new MemberException("No member with cardId "+cardId);
		
		member.get().getIdCard().setName(memberdto.getName());
		member.get().getIdCard().setAddress(memberdto.getAddress());
		member.get().getIdCard().setCity(memberdto.getCity());
		member.get().getIdCard().setDateOfBirth(memberdto.getDobDateOfBirth());
		member.get().getIdCard().setGender(memberdto.getGender());
		member.get().getIdCard().setState(memberdto.getState());
		
		memberRepo.save(member);
		return member.get();
	}

}
