package com.samuel.entity;

public class Person {
	private int id;
	private String name;
	private int age;
	private String nrc;
	
	public Person() {}
	
	public Person(String name, int age, String nrc) {
		super();
		this.name = name;
		this.age = age;
		this.nrc = nrc;
	}

	public Person(int id, String name, int age, String nrc) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.nrc = nrc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getNrc() {
		return nrc;
	}
}