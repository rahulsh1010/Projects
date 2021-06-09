package com.model;

public class Player {

	private String name;
	private int seed;
	private int age;
	private int noOfTournaments;
	private String nationality;
	private String strength;
	
	
	public Player(String name, int age, int seed, int noOfTournaments, String nationality, String strength) {
		super();
		this.name = name;
		this.seed = seed;
		this.age = age;
		this.noOfTournaments = noOfTournaments;
		this.nationality = nationality;
		this.strength = strength;
	}
	public Player() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSeed() {
		return seed;
	}
	public void setSeed(int seed) {
		this.seed = seed;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getNoOfTournaments() {
		return noOfTournaments;
	}
	public void setNoOfTournaments(int noOfTournaments) {
		this.noOfTournaments = noOfTournaments;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getStrength() {
		return strength;
	}
	public void setStrength(String strength) {
		this.strength = strength;
	}
	
	
}

