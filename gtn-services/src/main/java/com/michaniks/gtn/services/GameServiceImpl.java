package com.michaniks.gtn.services;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.michaniks.gtn.dao.GameDAO;
import com.michaniks.gtn.entities.Game;
import com.michaniks.gtn.entities.Guess;

@Stateless
public class GameServiceImpl implements GameService {
	
	@EJB
	private GameDAO gameDao;
	
	@EJB
	private GuessService guessService;
	
	@Override						
	public Game createGame(String name) {
		return gameDao.addGame(name);
	}

	@Override
	public Guess checkGuess(Guess guess) {
		return guessService.checkGuess(guess);
	}
	
}
