package com.example.SpringProjection.Dto;

import org.springframework.beans.factory.annotation.Value;

public interface PersonView {
	
	@Value("#{target.firstName + ' ' + target.lastName}")
    String getFullName();
	
//	default String getFullName() {
//	    return getFirstname.concat(" ").concat(getLastname());
//	  }

}
