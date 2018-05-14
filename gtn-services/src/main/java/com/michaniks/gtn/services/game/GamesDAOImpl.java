package com.michaniks.gtn.services.game;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import javax.ejb.Singleton;
import javax.ejb.Stateless;

import com.michaniks.gtn.services.game.classes.Game;
import com.michaniks.gtn.services.game.classes.NumberGenerator;

@Singleton
public class GamesDAOImpl implements GameDAO {
	
	private Map<Integer, Game> games = new HashMap<>();

	@Override
	public Integer addGame(String playerName) {
		Integer uid = NumberGenerator.generateUniqueId();
		games.put(uid, new Game(playerName));
		return uid;
	}

	@Override
	public Map<Integer, Game> getGames() {
		return games;
	}
	
}
