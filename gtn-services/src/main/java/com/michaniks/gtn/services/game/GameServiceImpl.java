package com.michaniks.gtn.services.game;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.michaniks.gtn.services.game.classes.Game;

@Stateless
public class GameServiceImpl implements GameService {
	
	@EJB
	private GameDAO gameDao;
	
	@Override						
	public Game createGame(String name) {
		return gameDao.addGame(name);
	}
	
}
