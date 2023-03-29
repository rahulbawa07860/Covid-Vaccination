package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Models.IdCard;

public interface IdCardRepo extends JpaRepository<IdCard, Integer> {

}
