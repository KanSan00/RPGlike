package com.arakan.rpglike.model;

public class Character {
	
	protected String name;
	protected int hp = 100;
	protected int maxHp = 100;
	protected int attackPower = 10;
	
	public Character(String name, int hp, int maxHp, int attackPower) {
		this.name = name;
		this.hp = hp;
		this.maxHp = maxHp;
		this.attackPower = attackPower;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHp() {
		return hp;
	}
	public int getMaxHp() {
		return maxHp;
	}
	public int getAttackPower() {
		return attackPower;
	}
	
	// 攻撃
    public void attack(Character target) {
        System.out.println(name + " の攻撃！");
        target.takeDamage(attackPower);
    }

    // ダメージ処理
    public void takeDamage(int damage) {
        hp -= damage;
        System.out.println(name + " は "+ damage + " ダメージ受けた！");
        // HPがマイナスにならないように
        if (hp < 0) {
            hp = 0;
        }
        System.out.println(name + " のHP: " + hp);
    }

    // 死亡判定
    public boolean isDead() {
        return hp <= 0;
    }
}
