package com.michaniks.gtn.services.game;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.michaniks.gtn.services.game.classes.Game;
import com.michaniks.gtn.services.game.classes.Guess;
import com.michaniks.gtn.services.game.classes.GuessChecker;

@Stateless
public class GameServiceImpl implements GameService {
	
	@EJB
	private GameDAO gameDao;
	
	@Override						
	public Game createGame(String name) {
		return gameDao.addGame(name);
	}

	@Override
	public Guess checkGuess(Guess guess) {
		return GuessChecker.checkGuess(guess);
	}
	
}
