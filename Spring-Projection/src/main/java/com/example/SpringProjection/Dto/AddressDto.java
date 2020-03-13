package com.example.SpringProjection.Dto;

public class AddressDto {
	
    private Long id;
    
    private String state;
  
    private String city;
  
    private String street;
  
    private String zipCode;
    
    

	public AddressDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddressDto(Long id, String state, String city, String street, String zipCode) {
		super();
		this.id = id;
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
