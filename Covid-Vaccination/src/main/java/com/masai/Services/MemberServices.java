package com.masai.Services;

import com.masai.Exceptions.MemberException;
import com.masai.Models.Member;
import com.masai.dto.MemberUpdateDTO;

public interface MemberServices {
	
	public Member getMemberById(String key,int Id) throws LoginException, MemberException;
	
	public Member getMemberByAadharNo(Long aadharNo) throws MemberException;
	
	public Member getMemberByPanNo(String panNo) throws MemberException;
	
	public Member addMember(Member member) throws MemberException;
	
	public Member updateMember(String key, Integer cardId, MemberUpdateDTO memberdto) throws LoginException, IdCardException, MemberException;
	
	public boolean deleteMember(String key, int Id) throws LoginException, MemberException;
	
	

}
