package com.masai.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.Models.VaccinationCenter;


@Repository
public interface VaccinationCenterRepository extends JpaRepository<VaccinationCenter, Integer>{
	

}
