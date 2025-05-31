package com.samuel.entity;

public class Address {
	private int id;
	private String state;
	private String township;
	private String street;
	public Address(int id, String state, String township, String street) {
		super();
		this.id = id;
		this.state = state;
		this.township = township;
		this.street = street;
	}
	
	public Address(String state, String township, String street) {
		super();
		this.state = state;
		this.township = township;
		this.street = street;
	}

	public int getId() {
		return id;
	}

	public String getState() {
		return state;
	}

	public String getTownship() {
		return township;
	}

	public String getStreet() {
		return street;
	}
}
