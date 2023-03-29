package com.masai.Services;

import java.util.List;

import javax.security.auth.login.LoginException;

import com.masai.Exceptions.AppointmentException;
import com.masai.Models.Appointment;

public interface AppointmentService {
	public Appointment addAppointment(String key, Appointment appointment, String aadharNo, Integer centerCode ) throws LoginException, MemberException, VaccinationCenterException, VaccineRegistrationException, VaccineInventoryException, AppointmentException;
	public List<Appointment> getAllAppointments(String Key) throws AppointmentException, LoginException;
    public Appointment updateAppointment(String Key, String aadharNo, Appointment appointment) throws AppointmentException, LoginException;
    public Boolean deleteAppointment(String key, String aadharNo) throws AppointmentException, LoginException;
	public Appointment getAppointment(String key, String aadharNo);
    
}
