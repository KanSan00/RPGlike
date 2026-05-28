package com.arakan.rpglike.model;

public class Player extends Character{
	int level;
	int exp;
	
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	
	public int attack() {
		return attackPower;
	}
	
	public void heal() {
		
	}
}
