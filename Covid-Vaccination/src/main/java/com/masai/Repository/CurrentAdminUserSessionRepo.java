package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Models.CurrentAdminUserSession;

public interface CurrentAdminUserSessionRepo extends JpaRepository<CurrentAdminUserSession, Integer>{

	CurrentAdminUserSession findByUuid(String key);

}
