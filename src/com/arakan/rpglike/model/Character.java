package com.arakan.rpglike.model;

public class Character {
	
	protected String name;
	protected int hp;
	protected int maxHp;
	protected int defense;

	protected int attackPower;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getMaxHp() {
		return maxHp;
	}
	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}
	public int getDefense() {
		return defense;
	}
	public void takeDamage() {
		if(hp > 0) {
			
		}
	}
	
	public void isDead() {
		if(hp <= 0) {
			
		}
	}
}
