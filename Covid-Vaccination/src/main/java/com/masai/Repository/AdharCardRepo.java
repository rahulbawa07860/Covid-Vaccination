package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.Models.AdharCard;

@Repository
public interface AdharCardRepo extends JpaRepository<AdharCard, Integer> {
	
	public AdharCard findByAdharNo(String adharNo);

}
