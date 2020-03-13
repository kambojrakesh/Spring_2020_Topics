package com.example.SpringProjection.Dto;

public class Order {

	private Customer customer;
	
	private AddressDto address;
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public AddressDto getAddress() {
		return address;
	}
	public void setAddress(AddressDto address) {
		this.address = address;
	}
	
	
}
