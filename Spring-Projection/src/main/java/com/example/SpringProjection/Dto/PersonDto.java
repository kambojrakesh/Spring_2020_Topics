package com.example.SpringProjection.Dto;

public class PersonDto {
	
    private Long id;
  
    private String firstName;
  
    private String lastName;
    
    private AddressDto address;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public AddressDto getAddress() { 
		  return address; 
		  }
	  
	  public void setAddress(AddressDto address) { 
		  this.address = address; 
		  }
	 
    
    

}
