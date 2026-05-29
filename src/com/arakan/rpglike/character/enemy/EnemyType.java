package com.arakan.rpglike.character.enemy;

public enum EnemyType {
	SLIME(30),
    GOBLIN(30),
    SKELETON(30),
	DRAGON(10);
    // 今後敵が増えたらここに追加するだけ
    
	int rate;
	
    EnemyType(int rate) {
    		this.rate = rate;
    }
    
    public int getRate() {
    		return this.rate;
    }
}
