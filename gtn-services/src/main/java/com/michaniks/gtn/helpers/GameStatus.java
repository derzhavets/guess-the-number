package com.michaniks.gtn.helpers;

import com.michaniks.gtn.entities.Game;
import com.michaniks.gtn.entities.Guess;

public enum GameStatus {
	
	CONTINUES,
	WON,
	WON_AND_SAVED,
	GUESS_NUMBER_EXCEEDED;

	public static void update(Game game, Guess guess) {
		game.setStatus(
				game.getGuesses().size() > 20 ? GUESS_NUMBER_EXCEEDED 
				: guess.getCorrectPositions() == 4 ? WON : CONTINUES);
	}	
}
