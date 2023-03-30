package com.masai.Services;

import com.masai.Exceptions.LoginException;
import com.masai.Exceptions.MemberException;
import com.masai.Models.Member;
import com.masai.dto.MemberUpdateDTO;

public interface MemberServices {
	
	public Member getMemberById(String key,Integer cardId) throws LoginException, MemberException;
	
	public Member getMemberByAadharNo(String key, String aadharNo) throws MemberException, LoginException;
	
	public Member getMemberByPanNo(String key, String panNo) throws MemberException, LoginException;
	
	public Member addMember(Member member) throws MemberException;
	
	public Member updateMember(String key, Integer cardId, MemberUpdateDTO memberdto) throws LoginException, MemberException;
	
	public boolean deleteMember(String key, Integer cardId) throws LoginException, MemberException;
	
	

}
