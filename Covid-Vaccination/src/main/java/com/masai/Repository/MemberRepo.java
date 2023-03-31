package com.masai.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.masai.Models.IdCard;
import com.masai.Models.Member;

@Repository
public interface MemberRepo extends JpaRepository<Member, Integer>{
	
	@Query("from Member where idCard.panCard.panNo=:pnum")
	public Member findByPanNo(@Param("pnum") String panno);
	
	@Query("from Member where idCard.Id=:card")
	public Member findByidCard(@Param("card") int idcardid);

	@Query("from Member where idCard.adharCard.adharNo=:ano")
	public Member findByAdharcardNo(@Param("ano") String adarno);

	public void save(Optional<Member> member);

	public Optional<Member> findByIdCard(Optional<IdCard> idCard);

	public Member findByEmail(String email);

	
	
	

}
