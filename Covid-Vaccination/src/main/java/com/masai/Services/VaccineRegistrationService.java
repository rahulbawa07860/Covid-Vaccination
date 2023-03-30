package com.masai.Services;

import java.util.List;
import org.springframework.stereotype.Service;

import com.masai.Exceptions.LoginException;
import com.masai.Exceptions.MemberException;
import com.masai.Exceptions.VaccineRegistrationException;
import com.masai.Models.Member;
import com.masai.Models.VaccineRegistration;

@Service

public interface VaccineRegistrationService {
	public VaccineRegistration addVaccineRegistration ( String key, String aadharNo ,  VaccineRegistration vcr ) throws LoginException, VaccineRegistrationException , MemberException;

	public VaccineRegistration getVaccineRegistrationByMobNo ( String key, String mobileno ) throws LoginException,VaccineRegistrationException;
	
	public List<VaccineRegistration> getAllVaccineRegistrations(String key) throws LoginException,VaccineRegistrationException;
	
	public List<Member> getAllMembersByMobNo ( String key, String mobileno ) throws LoginException,VaccineRegistrationException ;
	
	public VaccineRegistration updateVaccineRegistration( String key, VaccineRegistration vcr ) throws LoginException,VaccineRegistrationException ;
	
	public VaccineRegistration deleteVaccineRegistration( String key, VaccineRegistration vcr ) throws LoginException,VaccineRegistrationException;

	

}
