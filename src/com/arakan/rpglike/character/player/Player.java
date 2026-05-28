package com.arakan.rpglike.character.player;

import com.arakan.rpglike.character.Character;

public class Player extends Character{
	private int level = 1;
	private int exp = 0;

	public Player(String name, int hp, int defense, int attackPower) {
		super(name, hp, defense, attackPower);
		// TODO 自動生成されたコンストラクター・スタブ
	}
	
	public int getLevel() {
		return level;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	
	public void levelUp() {
		
	}
}
