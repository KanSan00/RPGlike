package com.arakan.rpglike.character;

public class Character {
	
	protected String name;
	protected int hp = 100;
	protected int maxHp = 100;
	protected int defense = 1;

	protected int attackPower = 10;
	
	public Character(String name, int hp, int maxHp, int defense, int attackPower) {
		this.name = name;
		this.hp = hp;
		this.maxHp = maxHp;
		this.defense = defense;
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
	protected void setHp(int hp) {
		this.hp = hp;
	}
	public int getMaxHp() {
		return maxHp;
	}
	protected void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}
	public int getDefense() {
		return defense;
	}
	
	protected void setDefense(int defense) {
		this.defense = defense;
	}
	public int getAttackPower() {
		return attackPower;
	}
	protected void setAttackPower(int attackPower) {
		this.attackPower = attackPower;
	}
	
	// 攻撃
    public void attack(Character target) {
        System.out.println(name + " の攻撃！");
        target.takeDamage(attackPower);
    }

 // ダメージ処理（引数の意味を「受ける攻撃力」に変更）
    public void takeDamage(int incomingAttackPower) {
    	// 1. 専用のメソッドで実際のダメージを計算する
        int damage = calculateDamage(incomingAttackPower);
        this.hp -= damage;
        System.out.println(name + " は "+ damage + " ダメージ受けた！");
        
        if (this.hp < 0) {
            this.hp = 0;
        }
        System.out.println(name + " のHP: " + this.hp);
    }
    
    // 「受ける側」が自分の防御力を使って計算する
    protected int calculateDamage(int incomingAttackPower) {
        // シンプルな減算式：攻撃力 - 防御力
        int damage = incomingAttackPower - this.defense;
        
        // 防御力が高すぎてダメージが0やマイナス（回復）にならないよう、最低1ダメージを保証
        return Math.max(1, damage);
    }

    // Character.java (もしくは Player.java) に追加
    public void revive() {
        // 現在のHPを最大HPまで全回復させる
        this.hp = this.maxHp;
    }
    
    // 死亡判定
    public boolean isDead() {
        return hp <= 0;
    }
}
