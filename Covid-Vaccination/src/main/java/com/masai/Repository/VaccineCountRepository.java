package com.masai.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Models.VaccineCount;
import com.masai.Models.VaccineInventory;

public interface VaccineCountRepository extends JpaRepository<VaccineCount, Integer> {
	public VaccineCount findByVaccine(Vaccine v);
	public List<VaccineCount> findByInventory(VaccineInventory i);
}
