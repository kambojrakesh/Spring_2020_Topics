package com.example.SpringProjection;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.SpringProjection.Dao.AddressDao;
import com.example.SpringProjection.Dao.PersonDao;
import com.example.SpringProjection.Entity.AddressEntity;
import com.example.SpringProjection.Entity.PersonEntity;

@SpringBootApplication
public class SpringProjectionApplication implements CommandLineRunner{

	@Autowired
	PersonDao personDao;
	
	@Autowired
	AddressDao addressDao;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringProjectionApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
	
	
	  @Override 
	  public void run(String... args) throws Exception {
	  
	  AddressEntity address = new AddressEntity(); 
	  address.setStreet("Vikaspuri"); 
	  address.setCity("New Delhi");
	  address.setState("New Delhi"); 
	  address.setZipCode("110059");
	  
	  PersonEntity perEntity = new PersonEntity(); 
	  perEntity.setFirstName("Akanksha"); 
	  perEntity.setLastName("Saxena");
	  perEntity.setAddress(address);
	  
	  personDao.save(perEntity);
	  
	  AddressEntity address1 = new AddressEntity(); 
	  address1.setStreet("Nirman Vihar"); 
	  address1.setCity("Lucknow");
	  address1.setState("Uttar Pradesh"); 
	  address1.setZipCode("226007");
	  
	  PersonEntity perEntity1 = new PersonEntity(); 
	  perEntity1.setFirstName("Akki"); 
	  perEntity1.setLastName("S");
	  perEntity1.setAddress(address1);
	  
	  personDao.save(perEntity1);
	  
	  }
	 


}
