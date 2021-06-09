package com.model;

public class Match {
	
	private int number;
	private String name;
	private Player player1;
	private Player player2;
	
	
	
	public Match(int number, String name, Player player1, Player player2) {
		super();
		this.number = number;
		this.name = name;
		this.player1 = player1;
		this.player2 = player2;
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
	public Player getPlayer1() {
		return player1;
	}
	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}
	public Player getPlayer2() {
		return player2;
	}
	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}
	
	
	
	
	

}
