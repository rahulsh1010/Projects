package com.model;

public class Court {
	
	private int number;
	private String name;
	private String type;
	private int capacity;
	public Court() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Court(int number, String name, String type, int capacity) {
		super();
		this.number = number;
		this.name = name;
		this.type = type;
		this.capacity = capacity;
	}


	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	

}
