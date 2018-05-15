package com.michaniks.gtn.services.game;

import java.util.Map;

import com.michaniks.gtn.services.game.classes.Game;

public interface GameDAO {

	Game addGame(String name);
	
	Map<Integer, Game> getGames();

}