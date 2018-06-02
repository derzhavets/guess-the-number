package com.michaniks.gtn.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.michaniks.gtn.dao.GameDAO;
import com.michaniks.gtn.entities.Game;
import com.michaniks.gtn.entities.Guess;
import com.michaniks.gtn.helpers.GameNotFoundException;
import com.michaniks.gtn.helpers.GameStatus;

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
	public Guess checkGuess(Guess guess) throws GameNotFoundException {
		return guessService.checkGuess(guess);
	}

	@Override
	public GameStatus getGameStatus(int gameId) throws GameNotFoundException {
		return gameDao.getGame(gameId).getStatus();
	}

	@Override
	public List<Guess> getGuessesForGame(int gameId) throws GameNotFoundException {
		return gameDao.getGame(gameId).getGuesses();
	}

}
