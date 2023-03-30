package com.masai.Models;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CurrentAdminUserSession {
	
	@Id
	private Integer adminId;
	
	@Column(unique = true)
	private String uuid;
	
	private LocalDateTime loginTime;
	
	public CurrentAdminUserSession() {
		// TODO Auto-generated constructor stub
	}

	public CurrentAdminUserSession(Integer adminId, String uuid, LocalDateTime loginTime) {
		super();
		this.adminId = adminId;
		this.uuid = uuid;
		this.loginTime = loginTime;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public LocalDateTime getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(LocalDateTime loginTime) {
		this.loginTime = loginTime;
	}

	@Override
	public String toString() {
		return "CurrentAdminUserSession [adminId=" + adminId + ", uuid=" + uuid + ", loginTime=" + loginTime + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(adminId, loginTime, uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CurrentAdminUserSession other = (CurrentAdminUserSession) obj;
		return Objects.equals(adminId, other.adminId) && Objects.equals(loginTime, other.loginTime)
				&& Objects.equals(uuid, other.uuid);
	}
	
	

}
