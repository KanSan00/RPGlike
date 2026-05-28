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

		// Listの size() と get() を使ってランダムに1つ選択
        EnemyType selectedType = types.get(rand.nextInt(types.size()));
        
        // 選ばれたEnumの型で判定する
        switch (selectedType) {
            case SLIME:
                return new Slime();
            case GOBLIN:
                return new Goblin();
            default:
                return new Slime(); // フェイルセーフ（安全策）
        }
    }
}
