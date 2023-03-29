package com.masai.Models;

import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.masai.Enums.Fingerprint;
import com.masai.Enums.IrisScan;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class AdharCard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer adharId;
	
	@Pattern( regexp = "^[0-9]{12}",message = "the number should be 12 digit")
	@Column(unique = true)
	private String adharNo;
	
	@NotNull(message = "Fingerprint can be null")
	@NotEmpty(message = "Fingerprint can't be empty")
	@NotBlank(message = "Fingerprint can't be blank")
	@Enumerated(EnumType.STRING)
	private Fingerprint fingerprints;
	
	
	@NotNull(message = "irisscan can be null")
	@NotEmpty(message = "irisscan can't be empty")
	@NotBlank(message = "irisscan can't be blank")
	@Enumerated(EnumType.STRING)
	private IrisScan irisscan;
	
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "adharCard")
	@JsonIgnore
	private IdCard idCard;

	public AdharCard() {
		
		// TODO Auto-generated constructor stub
	}

	public AdharCard(Integer adharId,
			@Pattern(regexp = "^[0-9]{12}", message = "the number should be 12 digit") String adharNo,
			@NotNull(message = "Fingerprint can be null") @NotEmpty(message = "Fingerprint can't be empty") @NotBlank(message = "Fingerprint can't be blank") Fingerprint fingerprints,
			@NotNull(message = "irisscan can be null") @NotEmpty(message = "irisscan can't be empty") @NotBlank(message = "irisscan can't be blank") IrisScan irisscan,
			IdCard idCard) {
		super();
		this.adharId = adharId;
		this.adharNo = adharNo;
		this.fingerprints = fingerprints;
		this.irisscan = irisscan;
		this.idCard = idCard;
	}

	public Integer getAdharId() {
		return adharId;
	}

	public void setAdharId(Integer adharId) {
		this.adharId = adharId;
	}

	public String getAdharNo() {
		return adharNo;
	}

	public void setAdharNo(String adharNo) {
		this.adharNo = adharNo;
	}

	public Fingerprint getFingerprints() {
		return fingerprints;
	}

	public void setFingerprints(Fingerprint fingerprints) {
		this.fingerprints = fingerprints;
	}

	public IrisScan getIrisscan() {
		return irisscan;
	}

	public void setIrisscan(IrisScan irisscan) {
		this.irisscan = irisscan;
	}

	public IdCard getIdCard() {
		return idCard;
	}

	public void setIdCard(IdCard idCard) {
		this.idCard = idCard;
	}

	@Override
	public String toString() {
		return "AdharCard [adharId=" + adharId + ", adharNo=" + adharNo + ", fingerprints=" + fingerprints
				+ ", irisscan=" + irisscan + ", idCard=" + idCard + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(adharId, adharNo, fingerprints, idCard, irisscan);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AdharCard other = (AdharCard) obj;
		return Objects.equals(adharId, other.adharId) && Objects.equals(adharNo, other.adharNo)
				&& fingerprints == other.fingerprints && Objects.equals(idCard, other.idCard)
				&& irisscan == other.irisscan;
	}

	
	
	

	
	
	
	
	
	
	
	

}
