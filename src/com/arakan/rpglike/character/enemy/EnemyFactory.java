package com.arakan.rpglike.character.enemy;

import java.util.List;
import java.util.Random;

public class EnemyFactory {

	private Random rand;
	// Enumの全要素を不変のListとしてあらかじめ保持しておく
    private final List<EnemyType> types = List.of(EnemyType.values());
	
	public EnemyFactory() {
		this.rand = new Random();
	}
	
	public Enemy createRandomEnemy() {
		int totalRate = 0;
		for(EnemyType type: types) {
			totalRate += type.getRate();
		}
		int num = this.rand.nextInt(totalRate);
		int total = 0;
		for(EnemyType type: types) {
			total += type.getRate();
			if(total < num) {
				switch(type) {
				case SLIME: return new Slime();
				case GOBLIN: return new Goblin();
				case SKELETON: return new Skeleton();
				case DRAGON: return new Dragon();
				default: return new Slime();
				}
			}
		}
		
		// 何かあったときは雑魚を返しておく
		return new Slime();
    }
}
