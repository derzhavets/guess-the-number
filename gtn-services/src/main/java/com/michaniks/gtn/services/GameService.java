package com.michaniks.gtn.services;

import java.util.List;

import javax.ejb.Local;

import com.michaniks.gtn.entities.Game;
import com.michaniks.gtn.entities.Guess;
import com.michaniks.gtn.helpers.GameStatus;

@Local
public interface GameService {

	Game createGame(String name);

	Guess checkGuess(Guess guess);

	GameStatus getGameStatus(int gameId);

	List<Guess> getGuessesForGame(int gameId);

}