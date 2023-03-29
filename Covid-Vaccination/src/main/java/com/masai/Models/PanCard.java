package com.masai.Models;

import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class PanCard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer panId;
	
	@NotNull(message = "panNo should not be null")
	@NotBlank(message = "panNo should not be blank")
	@NotEmpty(message = "panNo should not be Empty")
	@Size(min = 10, max = 10, message = "{user.invalid.panNumber}")
	@Column(unique = true)
	private String panNo;
	
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "panCard")
	@JsonIgnore
	private IdCard idCard;

	public Integer getPanId() {
		return panId;
	}

	public void setPanId(Integer panId) {
		this.panId = panId;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public IdCard getIdCard() {
		return idCard;
	}

	public void setIdCard(IdCard idCard) {
		this.idCard = idCard;
	}

	public PanCard() {
		
		// TODO Auto-generated constructor stub
	}

	public PanCard(Integer panId,
			@NotNull(message = "panNo should not be null") @NotBlank(message = "panNo should not be blank") @NotEmpty(message = "panNo should not be Empty") @Size(min = 10, max = 10, message = "{user.invalid.panNumber}") String panNo,
			IdCard idCard) {
		super();
		this.panId = panId;
		this.panNo = panNo;
		this.idCard = idCard;
	}

	@Override
	public String toString() {
		return "PanCard [panId=" + panId + ", panNo=" + panNo + ", idCard=" + idCard + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCard, panId, panNo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PanCard other = (PanCard) obj;
		return Objects.equals(idCard, other.idCard) && Objects.equals(panId, other.panId)
				&& Objects.equals(panNo, other.panNo);
	}
	
	

	
	
	
	

}
