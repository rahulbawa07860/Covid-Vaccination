package com.masai.Models;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CurrentMemberUserSession {
	
	@Id
	private Integer memberId;
	
	@Column(unique = true)
	private String uuid;
	
	private LocalDateTime loginTime;
	
	public CurrentMemberUserSession() {
		// TODO Auto-generated constructor stub
	}

	public CurrentMemberUserSession(Integer adminId, String uuid, LocalDateTime loginTime) {
		super();
		this.memberId = adminId;
		this.uuid = uuid;
		this.loginTime = loginTime;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer adminId) {
		this.memberId = adminId;
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
		return "CurrentMemberUserSession [memberId=" + memberId + ", uuid=" + uuid + ", loginTime=" + loginTime + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(memberId, loginTime, uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CurrentMemberUserSession other = (CurrentMemberUserSession) obj;
		return Objects.equals(memberId, other.memberId) && Objects.equals(loginTime, other.loginTime)
				&& Objects.equals(uuid, other.uuid);
	}
	
	

}
