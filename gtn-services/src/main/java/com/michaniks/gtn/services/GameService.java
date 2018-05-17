package com.michaniks.gtn.services;

import javax.ejb.Local;

import com.michaniks.gtn.entities.Game;
import com.michaniks.gtn.entities.Guess;

@Local
public interface GameService {

	Game createGame(String name);

	Guess checkGuess(Guess guess);

}