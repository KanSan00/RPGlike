package com.arakan.rpglike.character.enemy;

public class Goblin extends Enemy {
    public Goblin() {
    	// 名前, HP, 最大HP, 防御力, 攻撃力, 経験値 を親クラスに渡す
        super("ゴブリン", 30, 20, 1, 5, 250);
    }
}
