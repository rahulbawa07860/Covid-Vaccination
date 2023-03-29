package com.masai.Services;

import com.masai.Exceptions.AdharCardException;
import com.masai.Exceptions.IdCardException;
import com.masai.Exceptions.PanCardException;
import com.masai.Models.IdCard;

public interface IdCardService {
	
    public IdCard addIdCard(IdCard idCard) throws IdCardException;
	
	public IdCard findIdCardByAdharNo(String adharNo) throws IdCardException,AdharCardException;
	
	public IdCard findIdCardBypanNo(String panNo) throws IdCardException,PanCardException;

}
