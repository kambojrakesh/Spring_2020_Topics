package com.example.SpringProjection.Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class AddressEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
    private Long id;
  
	@OneToOne(mappedBy = "address")
    private PersonEntity person;
  
    private String state;
  
    private String city;
  
    private String street;
  
    private String zipCode;

	public AddressEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddressEntity(Long id, PersonEntity person, String state, String city, String street, String zipCode) {
		super();
		this.id = id;
		this.person = person;
		this.state = state;
		this.city = city;
		this.street = street;
		this.zipCode = zipCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PersonEntity getPerson() {
		return person;
	}

	public void setPerson(PersonEntity person) {
		this.person = person;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
    
    

}
