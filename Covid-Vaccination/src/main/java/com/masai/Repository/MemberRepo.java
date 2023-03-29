package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.Models.Member;

@Repository
public interface MemberRepo extends JpaRepository<Member, Integer>{

	Member findByAadharCardNo(Long aadharNo);

	Member findByPanNo(String panNo);
	
	

}
