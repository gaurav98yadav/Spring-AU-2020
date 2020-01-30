package com.hibernate.model;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

	public Address(int pincode, String street) {
		super();
		this.pincode = pincode;
		Street = street;
	}
	private int pincode;
	private String Street;
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getStreet() {
		return Street;
	}
	public void setStreet(String street) {
		Street = street;
	}
	public Address() {}
	
}
