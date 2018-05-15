package com.michaniks.gtn.services.game;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.Singleton;

import com.michaniks.gtn.services.game.classes.Game;
import com.michaniks.gtn.services.game.classes.NumberGenerator;

@Singleton
public class GamesDAOImpl implements GameDAO {
	
	private Map<Integer, Game> games = new HashMap<>();

	@Override
	public Game addGame(String playerName) {
		Integer uid = NumberGenerator.generateUniqueId();
		Game newGame = new Game(uid, playerName);
		games.put(uid, newGame);
		return newGame;
	}

	@Override
	public Map<Integer, Game> getGames() {
		return games;
	}
	
}
