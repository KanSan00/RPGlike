package com.arakan.rpglike;

import com.arakan.rpglike.character.player.Player;
import com.arakan.rpglike.model.Game;
import com.arakan.rpglike.save.SaveManager;

public class Main {

	public static void main(String[] args) {
		Player player = new Player("", 1,1,1,1);
		SaveManager.load(player);
	    Game game = new Game(player);
	    game.start();
	}

}
