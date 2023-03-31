package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Models.CurrentMemberUserSession;

public interface CurrentMemberUserSessionRepo extends JpaRepository<CurrentMemberUserSession, Integer>{

	CurrentMemberUserSession findByUuid(String key);

	CurrentMemberUserSession findByMemberId(Integer memberId);

}
