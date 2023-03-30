package com.masai.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exceptions.LoginException;
import com.masai.Exceptions.MemberException;
import com.masai.Exceptions.VaccineRegistrationException;
import com.masai.Models.Member;
import com.masai.Models.VaccineRegistration;
import com.masai.Repository.VaccineRegistrationRepository;

public class VaccineRegistrationSeviceImpl implements VaccineRegistrationService {
	
	@Autowired
	private VaccineRegistrationRepository vcRegRepo;
	
	@Autowired
	private CurrentUserRepo currRepo;
	
	@Autowired
	private MemberRepo memRepo;

	@Override
	public VaccineRegistration addVaccineRegistration(String key, String aadharNo, VaccineRegistration vcr)
			throws LoginException, VaccineRegistrationException, MemberException {
		
		CurrentUser cus = currRepo.findByUuid(key);
        
		if( cus != null ) {
			
			VaccineRegistration vR = vcRegRepo.findByMobileno(vcr.getMobileno());
			
			
			if( vR == null ) {
				
				Member member = memRepo.findByAdharcardNo(aadharNo);
				
				if( member != null ) {
					
					member.setVaccineRegistration(vcr);
					vcr.getMembers().add(member);
					
					return vcRegRepo.save(vcr);
					
				}else {
					
					throw new MemberException( "No Member found " );
				}
			}else {
				
				
				throw new VaccineRegistrationException("Vaccine Registration already done with this mobile number ");
			}
			
		}else {
			
			throw new LoginException("Please login first");
		}
	}

	@Override
	public VaccineRegistration getVaccineRegistrationByMobNo(String key, String mobileno)
			throws LoginException, VaccineRegistrationException {
		
         CurrentUser cus = currRepo.findByUuid(key);
        
		 if( cus != null ) {
			 VaccineRegistration VR = vcRegRepo.findByMobileno(mobileno);
				
				
				if( VR != null ) {
					
					
					return VR;
				}else {
					
					
					throw new VaccineRegistrationException(" No Vaccine Registration Details found with this mobile number ");
				}
				
			}else {
				
				throw new LoginException("Please Login First");
			}
		 }
	

	@Override
	public List<VaccineRegistration> getAllVaccineRegistrations(String key)
			throws LoginException, VaccineRegistrationException {
		
		
		 CurrentUser cus = currRepo.findByUuid(key);
	        
		 if( cus != null ) {
			 
			 List<VaccineRegistration> vaccineRegistrations = vcRegRepo.findAll();
				
				
				if( ! vaccineRegistrations.isEmpty() ) {
					
					
					return vaccineRegistrations;
				}else {
					
					
					throw new VaccineRegistrationException(" No Vaccine Registration Details found ");
				}
				
			}else {
				
				throw new LoginException("Please Login First");
			}
		 }
	

	@Override
	public List<Member> getAllMembersByMobNo(String key, String mobileno)
			throws LoginException, VaccineRegistrationException {
		
		CurrentUser cus = currRepo.findByUuid(key);
        
		 if( cus != null ) {
			 
			 VaccineRegistration VR = vcRegRepo.findByMobileno(mobileno);
				
				
				if( VR != null ) {
					
					
					if( ! VR.getMembers().isEmpty() ) {
						
						
						return VR.getMembers();
					}else {
						
						
						throw new VaccineRegistrationException(" No Member found with this registerd mobile number ");
					}
					
				}else {
					
					
					throw new VaccineRegistrationException(" No Vaccine Registration found with this mobile number ");
				}
				
			}else {
				
				throw new LoginException("Please Login First");
			}
		 }
		
	

	@Override
	public VaccineRegistration updateVaccineRegistration(String key, VaccineRegistration vcr)
			throws LoginException, VaccineRegistrationException {
		
		CurrentUser cus = currRepo.findByUuid(key);
        
		 if( cus != null ) {
		
		Optional<VaccineRegistration> optional = vcRegRepo.findById(vcr.getRegId());
		
		if(optional.isPresent()) {
			
			
			VaccineRegistration registerd = optional.get();
			
			
			registerd.setMobileno(vcr.getMobileno());
			
			
			return vcRegRepo.save(registerd);
			
		}else {
			
			
			throw new VaccineRegistrationException(" No Vaccine Registration Details found with this Id ");
		}
		
	}else {
		
		throw new LoginException("Please Login First");
	}
	}

	@Override
	public VaccineRegistration deleteVaccineRegistration(String key, VaccineRegistration vcr)
			throws LoginException, VaccineRegistrationException {
		
		
		CurrentUser cus = currRepo.findByUuid(key);
        
		 if( cus != null ) {
			 Optional<VaccineRegistration> optional = vcRegRepo.findById(vcr.getRegId());
				
				
				if(optional.isPresent()) {
					
					
					VaccineRegistration registerd = optional.get();
					
					
					vcRegRepo.delete(registerd);
					
					
					return registerd;
					
				}else {
					
					
					throw new VaccineRegistrationException(" No Vaccine Registration Details found with this Id ");
				}	
				
			}else {
				
				throw new LoginException("Please Login First");
			}
		}
		 
	}


