package com.arakan.rpglike.character.enemy;

import com.arakan.rpglike.character.Character;

public class Enemy extends Character{

	int exp = 100;
	
	public Enemy(String name, int hp, int defense, int attackPower, int exp) {
		super(name, hp, defense, attackPower);
		
		this.exp = exp;
	}

	public int getExp() {
		return exp;
	}
}