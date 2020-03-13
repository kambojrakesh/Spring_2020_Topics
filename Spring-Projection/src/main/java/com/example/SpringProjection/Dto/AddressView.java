package com.example.SpringProjection.Dto;

import org.springframework.beans.factory.annotation.Value;

//Interface Based Projection
public interface AddressView {
	
	String getZipCode();
	
	@Value("#{target.city}")			//target is backing entity object
	String livingIn();

}
