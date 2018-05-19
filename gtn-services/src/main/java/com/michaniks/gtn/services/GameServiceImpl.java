package com.michaniks.gtn.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.michaniks.gtn.dao.GameDAO;
import com.michaniks.gtn.dao.ScoresDAO;
import com.michaniks.gtn.entities.Game;
import com.michaniks.gtn.entities.Guess;
import com.michaniks.gtn.entities.Score;
import com.michaniks.gtn.helpers.GameStatus;

@Stateless
public class GameServiceImpl implements GameService {
	
	@EJB
	private GameDAO gameDao;
	
	@EJB
	private GuessService guessService;
	
	@EJB
	private ScoresDAO scoresDao;
	
	@Override						
	public Game createGame(String name) {
		return gameDao.addGame(name);
	}

	@Override
	public Guess checkGuess(Guess guess) {
		if (gameDao.getGame(guess.getGameId()) != null) {
			return guessService.checkGuess(guess);
		} else {
			return guess;
		}
	}

	@Override
	public GameStatus getGameStatus(int gameId) {
		Game game = gameDao.getGame(gameId);
		if (game == null) {
			return GameStatus.GAME_ID_NOT_FOUND;
		} else {
			return game.getStatus();
		}
	}

	@Override
	public List<Guess> getGuessesForGame(int gameId) {
		Game game = gameDao.getGame(gameId);
		if (game != null) {
			return game.getGuesses();
		} else {
			return null;
		}
	}
	
	@Override
	public List<Score> getAllScores() {
		return scoresDao.getAll();
	}
	
}
