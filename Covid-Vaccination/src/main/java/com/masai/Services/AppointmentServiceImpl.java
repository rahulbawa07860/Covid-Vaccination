package com.masai.Services;

import com.masai.Models.Member;
import java.util.List;
import java.util.Optional;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exceptions.AppointmentException;
import com.masai.Exceptions.MemberException;
import com.masai.Exceptions.VaccinationCenterException;
import com.masai.Exceptions.VaccineInventoryException;
import com.masai.Exceptions.VaccineRegistrationException;
import com.masai.Models.Appointment;
import com.masai.Models.CurrentMemberUserSession;
import com.masai.Models.VaccinationCenter;
import com.masai.Models.VaccineInventory;
import com.masai.Models.VaccineRegistration;
import com.masai.Repository.AppointmentRepository;
import com.masai.Repository.CurrentMemberUserSessionRepo;
import com.masai.Repository.MemberRepo;
import com.masai.Repository.VaccinationCenterRepository;
import com.masai.Repository.VaccineInventoryRepository;
import com.masai.Repository.VaccineRegistrationRepository;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
	private AppointmentRepository AppointmentRepo;      
    @Autowired
	private VaccineInventoryRepository VccInvRepo;
    @Autowired
	private CurrentMemberUserSessionRepo currSessRepo;
	@Autowired
	private VaccineRegistrationRepository VccRegRepo; 
	@Autowired
	private VaccinationCenterRepository VccCenRepo;
	@Autowired
	private MemberRepo memberRepo;
	@Override
	public Appointment addAppointment(String key, Appointment appointment, String aadharNo, Integer centerCode)
			throws LoginException, MemberException, VaccinationCenterException, VaccineRegistrationException,
			VaccineInventoryException, AppointmentException {

		//first we will check for logged in or not
		CurrentMemberUserSession cus = currSessRepo.findByUuid(key);
		
		//if logged in
		if( cus != null ) {
			
			//if user is admin or member
		
				
				//if user is member then 
				//here we need to find member to add appointment: 
				Member member = memberRepo.findByAdharcardNo(aadharNo);
				
				//if member found then we will check for Vaccine Registration by mob no of appointment:
				if( member != null ) {
					
					VaccineRegistration vr = VccRegRepo.findByMobileno(appointment.getMobileNo());
					
					//if vaccine registration found then we will check for member is in members list of vaccine registration:
					if( vr.getMembers().contains(member) ) {
						
						//if member found in registration then we will check for Vaccination center:
						Optional<VaccinationCenter> opt2 = VccCenRepo.findById(centerCode);
						
						//center found then we will save and return appointment:
						if( opt2.isPresent() ) {
							
							VaccinationCenter vaccinationCenter = opt2.get();
							
							VaccineInventory inventory = vaccinationCenter.getInventory();
							
							//if inventory is not empty
							if( ! inventory.getVaccineCount().isEmpty() ) {
								
								//first we will check if member has already taken dose1:
								if( member.getDose1Status() ) {
									
									//if dose 1 true then we will assign dose 2 as true:
									member.setDose1Status(appointment.getBookingStatus());
								}else {
									
									member.setDose1Status(appointment.getBookingStatus());
									member.setDose2Date(appointment.getDateOfBooking().plusMonths(3));
								}
								
								//saved member:
								memberRepo.save(member);
								
								//associated member with appointment:
								appointment.setMember(member);
								
//								vaccinationCenter.getAppointments().add(appointment);
								
								//saved and returned appointment:
								return AppointmentRepo.save(appointment);
								
							}else {
								
								throw new VaccineInventoryException("Vaccine inventory is empty !");
							}
							
							
						}else {
							
							throw new VaccinationCenterException("No Vaccination Center found !");
						}
						
					}else {
						
						throw new VaccineRegistrationException("No Vaccine Registration found !");
					}
					
					
				}else {
					
					throw new MemberException(" No member found ! ");
				}
				
			
		}else {
			
			throw new LoginException(" Please login first ! ");
		}
	}
	@Override
	public List<Appointment> getAllAppointments(String Key) throws AppointmentException, LoginException {
		// TODO Auto-generated method stub
		CurrentMemberUserSession  currentSession = currSessRepo.findByUuid(Key);
		if(currentSession!=null)
		{
			
			
				List<Appointment> appointments = AppointmentRepo.findAll();
				if(!appointments.isEmpty())
				{
					return appointments;
				}else {
					throw new AppointmentException("No appointment present");
				}
			
				
			}
			
		else {
			throw new LoginException(" Please login first!");
		
		}
	}
	@Override
	public Appointment updateAppointment(String Key, String aadharNo, Appointment appointment)
			throws AppointmentException, LoginException {
		// TODO Auto-generated method stub
		CurrentMemberUserSession  currentSession = currSessRepo.findByUuid(Key);
		if(currentSession!=null)
		{
			
				Member member = memberRepo.findByAdharcardNo(aadharNo);
				if(member.getAppointment()!=null)
				{
					Appointment enterAppointment = member.getAppointment();
					enterAppointment.setBookingStatus(appointment.getBookingStatus());
					enterAppointment.setDateOfBooking(appointment.getDateOfBooking());
					enterAppointment.setVaccinationCenter(appointment.getVaccinationCenter());
					enterAppointment.setSlot(appointment.getSlot());
					return AppointmentRepo.save(enterAppointment);
				}
				else {
					throw new AppointmentException("No appointment found");
				}
			
		}
		else {
			throw new LoginException(" Please login first!");
		}
	}
	@Override
	public Boolean deleteAppointment(String key, String aadharNo) throws AppointmentException, LoginException {
		// TODO Auto-generated method stub
		CurrentMemberUserSession  currentSession = currSessRepo.findByUuid(key);
		if(currentSession!=null)
		{
			Member member = memberRepo.findByAdharcardNo(aadharNo);
			if(member.getAppointment()!=null)
			{
				Appointment enterAppointment = member.getAppointment();
				AppointmentRepo.delete(enterAppointment);
				return true;			
		}else {
			throw new AppointmentException("No appointment found");
		}
		}
		else {
			throw new LoginException(" Please login first!");
		}
	}
	@Override
	public Appointment getAppointment(String key, String aadharNo) throws AppointmentException, LoginException {
		// TODO Auto-generated method stub
		CurrentMemberUserSession  currentSession = currSessRepo.findByUuid(key);
		if(currentSession!=null)
		{
			Member member = memberRepo.findByAdharcardNo(aadharNo);
			if(member !=null)
			{
				return member.getAppointment();
			}
			else {
				throw new AppointmentException("No appointment found with this aadhar No."+aadharNo);
			}
		}
		else {
			throw new LoginException(" Please login first!");
		
		}
	}
	
	
	
	
}
