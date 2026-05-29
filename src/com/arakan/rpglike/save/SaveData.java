package com.arakan.rpglike.save;

import com.arakan.rpglike.character.player.Player;

public class SaveData {

	private String name;
	private int level;
	private int hp;
	private int maxHp;

	private int defense;
	private int exp;
	private int nextLevelExp;
	private int attackPower;

	public SaveData() {

	}
	
	public void setData(Player player) {
		this.name = player.getName();
		this.level = player.getLevel();
		this.hp = player.getHp();
		this.maxHp = player.getMaxHp();
		this.defense = player.getDefense();
		this.exp = player.getExp();
		this.nextLevelExp = player.getNextLevelExp();
		this.attackPower = player.getAttackPower();
	}
	
	public void initializeData() {
		this.name = "";
		this.level = 1;
		this.hp = 100;
		this.maxHp = 100;
		this.defense = 5;
		this.exp = 0;
		this.nextLevelExp = 0;
		this.attackPower = 10;
	}
	
	public String getName() {
		return name;
	}

	public int getLevel() {
		return level;
	}
	
	public int getHp() {
		return hp;
	}
	
	public int getMaxHp() {
		return maxHp;
	}

	public int getDefense() {
		return defense;
	}
	
	public int getExp() {
		return exp;
	}
	
	public int getNextLevelExp() {
		return nextLevelExp;
	}
	
	public int getAttackPower() {
		return attackPower;
	}
}
