package com.masai.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exceptions.AdharCardException;
import com.masai.Exceptions.IdCardException;
import com.masai.Exceptions.PanCardException;
import com.masai.Models.AdharCard;
import com.masai.Models.IdCard;
import com.masai.Models.PanCard;
import com.masai.Repository.AdharCardRepo;
import com.masai.Repository.IdCardRepo;
import com.masai.Repository.PanCardRepo;

@Service
public class IdCardServiceImpl implements IdCardService {
	
	@Autowired
	private AdharCardRepo adharRepo;
	
	@Autowired
	private PanCardRepo panRepo;
	
	
	@Autowired
	private IdCardRepo idcardRepo;

	@Override
	public IdCard addIdCard(IdCard idCard) throws IdCardException {
		if(idCard != null) {
			idcardRepo.save(idCard);
			return idCard;
		}else {
			throw new IdCardException("Sorry you haven't filled the valid details of ID-Card");
		}
	}

	@Override
	public IdCard findIdCardByAdharNo(String adharNo) throws IdCardException, AdharCardException {
		AdharCard adharcrd = adharRepo.findByAdharNo(adharNo);
		
		if(adharcrd == null) {
			throw new AdharCardException("sorry there is no adhar card with that particular "+ adharNo);
		}else {
			Integer num = adharcrd.getAdharId();
			Optional<IdCard> opt = idcardRepo.findById(num);
			if(opt.isPresent()) {
				IdCard idcard = opt.get();
				return idcard;
			}else {
				throw new IdCardException("sorry there is no id with the particular adhaar number "+ adharNo);
			}
		}
	}

	@Override
	public IdCard findIdCardBypanNo(String panNo) throws IdCardException, PanCardException {
		PanCard pancard = panRepo.findByPanNo(panNo);
		
		if(pancard == null) {
			throw new PanCardException("sorry there is no pan card with that particular ");
		}else {
			IdCard idcard = pancard.getIdCard();
			return idcard;
		}
		
		
		
		
		
	}

}
