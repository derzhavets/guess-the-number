package com.michaniks.gtn.services.game;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class GameServiceImpl implements GameService {
	
	@EJB
	private GameDAO gameDao;
	
	@Override						
	public Integer createGame(String name) {
		return gameDao.addGame(name);
	}
	
}
