package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Models.PanCard;

public interface PanCardRepo extends JpaRepository<PanCard, Integer> {
	
	public PanCard findByPanNo(String panNo);

	
}
