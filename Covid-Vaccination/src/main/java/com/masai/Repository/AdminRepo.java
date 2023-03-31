package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.Exceptions.AdminException;
import com.masai.Models.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer>{
	
	public Admin findByEmail(String email) throws AdminException;

	public Admin findByAdminId(Integer adminId);

}
