package com.example.SpringProjection.Dto;

public class ClassDto {

	private final String firstName;
	  
    private final String lastName;       

	public ClassDto(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
}
