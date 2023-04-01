package com.masai.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.Models.VaccinationCenter;


@Repository  /* JPA Repository contains the APIs for basic CRUD operations,
                the APIS for pagination, and the APIs for sorting.*/
public interface VaccinationCenterRepository extends JpaRepository<VaccinationCenter, Integer>{
	

}
