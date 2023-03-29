package com.masai.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.masai.Models.VaccineRegistration;
import com.masai.Exceptions.*;

@Repository

public interface VaccineRegistrationRepository extends JpaRepository<VaccineRegistration, Integer> {

		public VaccineRegistration findByMobileno(String mobileno);
}
