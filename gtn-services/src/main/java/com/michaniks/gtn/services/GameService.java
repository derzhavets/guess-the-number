package com.michaniks.gtn.services;

import java.util.List;

import javax.ejb.Local;

import com.michaniks.gtn.entities.Game;
import com.michaniks.gtn.entities.Guess;
import com.michaniks.gtn.entities.Score;
import com.michaniks.gtn.helpers.GameNotFoundException;
import com.michaniks.gtn.helpers.GameStatus;

@Local
public interface GameService {

	Game createGame(String name);

	Guess checkGuess(Guess guess) throws GameNotFoundException;

	GameStatus getGameStatus(int gameId) throws GameNotFoundException;

	List<Guess> getGuessesForGame(int gameId) throws GameNotFoundException;

	List<Score> getAllScores();

}