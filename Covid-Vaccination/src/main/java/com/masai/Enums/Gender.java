package com.masai.Enums;

public enum Gender {
	
	    Male("Male"),
	    Female("Female"),
	    Other("Other");

	    private String gender;

	    private Gender(String gender) {
	        this.gender = gender;
	    }

	    public String getGen() {
	        return gender;
	    }
         
}
