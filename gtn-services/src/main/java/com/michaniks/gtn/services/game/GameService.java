package com.michaniks.gtn.services.game;

import com.michaniks.gtn.services.game.classes.Game;
import com.michaniks.gtn.services.game.classes.Guess;

public interface GameService {

	Game createGame(String name);

	Guess checkGuess(Guess guess);

}