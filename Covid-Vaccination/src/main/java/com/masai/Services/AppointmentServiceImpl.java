package com.masai.Services;

import java.lang.reflect.Member;
import java.util.List;
import java.util.Optional;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exceptions.AppointmentException;
import com.masai.Models.Appointment;
import com.masai.Repository.AppointmentRepository;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
	private AppointmentRepository AppointmentRepo;      
    @Autowired
	private VaccineInventoryRepository VccInvRepo;
    @Autowired
	private CurrentUserSessionRepo currSessRepo;
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
		// TODO Auto-generated method stub
		CurrentUserSession  currentSession = currSessRepo.findByUuid(key);
		if(currentSession!=null)
		{
			if(!currentSession.getAdmin())
			{
				Member member = memberRepo.findByAdharcardNo(aadharNo);
				if(member!=null)
				{
					VaccineRegistration vaccineregistration = VccRegRepo.findByMobileno(appointment.getMobileNo());
					if(vaccineregistration.getMembers().contains(member))
					{
						Optional<VaccinationCenter> optional = VccCenRepo.findById(centerCode);
						if(optional.isPresent())
						{
							VaccinationCenter vaccinationCenter = optional.get();
							VaccineInventory inventory = vaccinationCenter.getInventory();
							if(!inventory.getVaccineCount().isEmpty())
							{
								if(member.isDose1status())
								{
									member.setDose2status(appointment.getBookingStatus());
								}
								else {
									member.setDose1status(appointment.getBookingStatus());
									member.setDose2date(appointment.getDateOfBooking().plusMonths(3));
								}
								memberRepo.save(member);
								appointment.setMember(member);
								vaccinationCenter.getAppointments().add(appointment);
								return AppointmentRepo.save(appointment);
							}else {
								throw new VaccineInventoryException("Vaccine inventory is empty!");
							}
						}
						else {
							throw new VaccinationCenterException("No Vaccination Center found!");
						}
					}
					else {
						throw new VaccineRegistrationException("No Vaccine Registration found!");
					}
				}
				else {
					throw new MemberException(" No member found!");
				}
			}
			else {
				throw new LoginException("Please login as Member");
			}
		}
		else {
			throw new LoginException(" Please login first!");
		}
	}
	@Override
	public List<Appointment> getAllAppointments(String Key) throws AppointmentException, LoginException {
		// TODO Auto-generated method stub
		CurrentUserSession  currentSession = currSessRepo.findByUuid(key);
		if(currentSession!=null)
		{
			
			if(!currentSession.getAdmin())
			{
				List<Appointment> appointments = AppointmentRepo.findAll();
				if(!appointments.isEmpty())
				{
					return appointments;
				}else {
					throw new AppointmentException("No appointment present");
				}
			}else {
				throw new LoginException(" Please login as admin!");
				
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
		CurrentUserSession  currentSession = currSessRepo.findByUuid(key);
		if(currentSession!=null)
		{
			if(!currentSession.getAdmin())
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
				throw new LoginException(" Please login as admin!");
			}
		}
		else {
			throw new LoginException(" Please login first!");
		}
	}
	@Override
	public Boolean deleteAppointment(String key, String aadharNo) throws AppointmentException, LoginException {
		// TODO Auto-generated method stub
		CurrentUserSession  currentSession = currSessRepo.findByUuid(key);
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
	public Appointment getAppointment(String key, String aadharNo) {
		// TODO Auto-generated method stub
		CurrentUserSession  currentSession = currSessRepo.findByUuid(key);
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
