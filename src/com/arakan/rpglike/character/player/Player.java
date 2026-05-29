package com.arakan.rpglike.character.player;

import com.arakan.rpglike.character.Character;

public class Player extends Character{
	private int level = 1;
	private int exp = 0;
	private int nextLevelExp = 0;

	public Player(String name, int hp, int defense, int attackPower) {
		super(name, hp, defense, attackPower);
		this.nextLevelExp = calculateNextLevelExp();
	}
	
	public int getLevel() {
		return level;
	}
	
	public int getExp() {
		return exp;
	}	
	
	public void gainExp(int exp) {
		this.exp += exp;
		System.out.println(getName() + "は " + exp + " のEXPを獲得した！");
		if(this.exp >= this.nextLevelExp) {
			levelUp();
		}
	}
	
	// 次のレベルに必要な経験値を計算する数式
    private int calculateNextLevelExp() {
        return this.level * 100; 
    }
	
	public void levelUp() {
		this.exp -= this.nextLevelExp;
		level += 1;
		
		this.nextLevelExp = calculateNextLevelExp();
		
		// ステータスを上昇させる（例：最大HP+15, 攻撃力+2）
        int hpBonus = 5;
        int attackBonus = 1;
        
        this.setMaxHp(this.getMaxHp() + hpBonus);
        this.setHp(this.getMaxHp()); // レベルアップ時にHP全回復
        this.setAttackPower(this.getAttackPower() + attackBonus);

        System.out.println("★ レベルアップ！ Lv." + (this.level - 1) + " -> Lv." + this.level);
        System.out.println("最大HPが " + hpBonus + " 上がった！ (HPが全回復した)");
        System.out.println("攻撃力が " + attackBonus + " 上がった！");
	}
	
	public String toString() {
		String status = "名前: "+name +
						"\nレベル: "+level+
						"\nHP: "+hp+
						"\n攻撃力: "+attackPower;
		return status;
	}

}
