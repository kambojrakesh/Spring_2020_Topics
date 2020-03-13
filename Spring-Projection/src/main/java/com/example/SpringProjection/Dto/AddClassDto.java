package com.example.SpringProjection.Dto;

public class AddClassDto {

	private final String state;
    
    private final String city;

    
    
	public AddClassDto() {
		super();
		this.city = "";
		this.state = "";
	}

	public AddClassDto(String state, String city) {
		super();
		this.state = state;
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public String getCity() {
		return city;
	}
    
    
}
