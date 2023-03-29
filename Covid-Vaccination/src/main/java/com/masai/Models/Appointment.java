package com.masai.Models;

import java.time.LocalDate;
import java.util.Objects;

import org.hibernate.annotations.GeneratorType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.masai.CovidVaccinationApplication;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bookingId;
	private String mobileNo;
	private String slot;
	private LocalDate dateOfBooking = LocalDate.now(); 
	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Member member;
	
	private Boolean bookingStatus;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private VaccinationCenter vaccinationCenter;

	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Appointment(Integer bookingId, String mobileNo, String slot, LocalDate dateOfBooking, Member member,
			Boolean bookingStatus, VaccinationCenter vaccinationCenter) {
		super();
		this.bookingId = bookingId;
		this.mobileNo = mobileNo;
		this.slot = slot;
		this.dateOfBooking = dateOfBooking;
		this.member = member;
		this.bookingStatus = bookingStatus;
		this.vaccinationCenter = vaccinationCenter;
	}

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getSlot() {
		return slot;
	}

	public void setSlot(String slot) {
		this.slot = slot;
	}

	public LocalDate getDateOfBooking() {
		return dateOfBooking;
	}

	public void setDateOfBooking(LocalDate dateOfBooking) {
		this.dateOfBooking = dateOfBooking;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Boolean getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(Boolean bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public VaccinationCenter getVaccinationCenter() {
		return vaccinationCenter;
	}

	public void setVaccinationCenter(VaccinationCenter vaccinationCenter) {
		this.vaccinationCenter = vaccinationCenter;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(bookingId, bookingStatus, dateOfBooking, mobileNo, slot);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Appointment other = (Appointment) obj;
		return Objects.equals(bookingId, other.bookingId) && Objects.equals(bookingStatus, other.bookingStatus)
				&& Objects.equals(dateOfBooking, other.dateOfBooking) && Objects.equals(mobileNo, other.mobileNo)
				&& Objects.equals(slot, other.slot);
	}

	@Override
	public String toString() {
		return "Appointment [bookingId=" + bookingId + ", mobileNo=" + mobileNo + ", slot=" + slot + ", dateOfBooking="
				+ dateOfBooking + ", bookingStatus=" + bookingStatus + "]";
	}
	
	
}
