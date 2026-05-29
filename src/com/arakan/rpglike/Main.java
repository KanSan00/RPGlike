package com.arakan.rpglike;

import com.arakan.rpglike.model.Game;
import com.arakan.rpglike.save.SaveManager;

public class Main {

	public static void main(String[] args) {
	    Game game = new Game(SaveManager.load());
	    game.start();
	}

}
