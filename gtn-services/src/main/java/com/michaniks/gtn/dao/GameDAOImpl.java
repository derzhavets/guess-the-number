package com.michaniks.gtn.dao;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.Singleton;

import com.michaniks.gtn.entities.Game;
import com.michaniks.gtn.helpers.NumberGenerator;

@Singleton
public class GameDAOImpl implements GameDAO {
	
	private Map<Integer, Game> games = new HashMap<>();

	@Override
	public Game addGame(String playerName) {
		Integer uid = NumberGenerator.generateUniqueId();
		Game newGame = new Game(uid, playerName);
		games.put(uid, newGame);
		return newGame;
	}

	@Override
	public Game getGame(Integer id) {
		return games.get(id);
	}
	
}
