package com.arakan.rpglike.model;

public class Enemy extends Character{

	int exp = 100;
	
	public Enemy(String name, int hp, int defense, int attackPower, int exp) {
		super(name, hp, defense, attackPower);
		
		this.exp = exp;
	}

	public int getExp() {
		return exp;
	}
	
	public void setExp(int exp) {
		this.exp = exp;
	}
	
	public void attack() {
		
	}
}