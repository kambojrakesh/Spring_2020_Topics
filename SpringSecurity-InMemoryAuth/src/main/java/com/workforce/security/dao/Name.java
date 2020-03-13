package com.workforce.security.dao;

public class Name {
	private String firstname;
	private String lastName;

	public Name(String fname, String lname) {
		this.firstname = fname;
		this.lastName = lname;

	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
