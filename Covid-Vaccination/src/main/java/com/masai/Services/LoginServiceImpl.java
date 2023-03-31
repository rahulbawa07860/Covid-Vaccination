package com.masai.Services;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Enums.Role;
import com.masai.Exceptions.AdminException;
import com.masai.Exceptions.LoginException;
import com.masai.Models.Admin;
import com.masai.Models.CurrentAdminUserSession;
import com.masai.Models.CurrentMemberUserSession;
import com.masai.Models.Member;
import com.masai.Models.User;
import com.masai.Repository.AdminRepo;
import com.masai.Repository.CurrentAdminUserSessionRepo;
import com.masai.Repository.CurrentMemberUserSessionRepo;
import com.masai.Repository.MemberRepo;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private MemberRepo memberRepo;
	
	@Autowired
	private AdminRepo adminRepo;
	
	@Autowired
	private CurrentAdminUserSessionRepo adminUserSessionRepo ;
	
	@Autowired
	private CurrentMemberUserSessionRepo memberUserSessionRepo;

	@Override
	public String login(User user) throws LoginException, AdminException {
		// TODO Auto-generated method stub
		if(user.getRole()==Role.ADMIN) {
			
			Admin existingAdmin = adminRepo.findByEmail(user.getEmail());
			
			if(existingAdmin==null) throw new AdminException("No admin is registered with email: "+user.getEmail());
			
			CurrentAdminUserSession adminUserSession = adminUserSessionRepo.findByAdminId(existingAdmin.getAdminId());
			
			if(adminUserSession!=null) throw new LoginException("Admin is already logged in");
			
			if(existingAdmin.getPassword().equals(user.getPassword())) {
				CurrentAdminUserSession aSession = new CurrentAdminUserSession();
				aSession.setAdminId(existingAdmin.getAdminId());
				aSession.setLoginTime(LocalDateTime.now());
				
				String uuid = RandomString.make(6);
				aSession.setUuid(uuid);
				
				adminUserSessionRepo.save(aSession);
				
				return aSession.toString();
			}else {
				throw new LoginException("Wrong password");
			}
			
		}else if(user.getRole()==Role.MEMBER){
			
			Member existingMember = memberRepo.findByEmail(user.getEmail());
			
			if(existingMember==null) throw new AdminException("No member is registered with email: "+user.getEmail());
			
			CurrentMemberUserSession memberUserSession = memberUserSessionRepo.findByMemberId(existingMember.getMemberId());
			
			if(memberUserSession!=null) throw new LoginException("Member is already logged in");
			
			if(existingMember.getPassword()==user.getPassword()) {
				CurrentMemberUserSession mSession = new CurrentMemberUserSession();
				mSession.setMemberId(existingMember.getMemberId());
				mSession.setLoginTime(LocalDateTime.now());
				
				String uuid = RandomString.make(6);
				mSession.setUuid(uuid);
				
				memberUserSessionRepo.save(mSession);
				
				return mSession.toString();
			}else {
				throw new LoginException("Wrong password");
			}
			
		}
		return "Please select a valid role";
		
	}

	@Override
	public String logout(String key, String role) throws LoginException {
		// TODO Auto-generated method stub
		if(role.equals("ADMIN")) {
			
			CurrentAdminUserSession adminUserSession = adminUserSessionRepo.findByUuid(key);
			
			if(adminUserSession==null) throw new LoginException("Admin not logged in");
			
			adminUserSessionRepo.delete(adminUserSession);
			
			return "Logged out";
			
		}else if(role.equals("MEMBER")) {
			
			CurrentMemberUserSession memberUserSession = memberUserSessionRepo.findByUuid(key);
			
			if(memberUserSession==null) throw new LoginException("Admin not logged in");
			
			memberUserSessionRepo.delete(memberUserSession);
			
			return "Logged out";
			
		}else return "Please select a valid role";
	}

}
