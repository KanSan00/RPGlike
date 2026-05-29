package com.arakan.rpglike.character.enemy;

public enum EnemyType {
	SLIME(50),
    GOBLIN(49),
	DRAGON(1);
    // 今後敵が増えたらここに追加するだけ
    
	int rate;
	
    EnemyType(int rate) {
    		this.rate = rate;
    }
    
    public int getRate() {
    		return this.rate;
    }
}
