package com.michaniks.gtn.services;

import static com.michaniks.gtn.helpers.GameStatus.WON;
import static com.michaniks.gtn.helpers.GameStatus.CONTINUES;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.michaniks.gtn.dao.GameDAO;
import com.michaniks.gtn.dao.ScoresDAO;
import com.michaniks.gtn.entities.Game;
import com.michaniks.gtn.entities.Guess;
import com.michaniks.gtn.entities.Score;

@Stateless
public class GuessServiceImpl implements GuessService {
	
	@EJB
	private GameDAO gameDao;
	
	@EJB
	private ScoresDAO scoresDao;
	
	@Override
	public Guess checkGuess(Guess guess) {
		Game game = gameDao.getGame(guess.getGameId());
		checkNumberAndUpdateGuess(game, guess);
		if (game.getStatus() == CONTINUES) {
				game.updateStatus(guess);
				game.addGuess(guess);
				guess.setGuessNumber(game.getGuesses().indexOf(guess) + 1);
		} 
		if (game.getStatus() == WON) {
			scoresDao.save(new Score(game.getPlayerName(), game.getGuesses().size()));
		}
		return guess;
	}
	
	private Guess checkNumberAndUpdateGuess(Game game, Guess guess) {
		Integer[] guessedNumberArray = convertToArray(guess.getGuessedNumber());
		Integer[] numberToGuess = game.getNumberToGuess();
		
		for (int i = 0; i < numberToGuess.length; i++) {
			for (int j = 0; j < guessedNumberArray.length; j++) {
				if (guessedNumberArray[j] == numberToGuess[i] && i == j) {
					guess.incrementCorrectPositions();
					guess.incrementCorrectNumbers();					
				} else if (guessedNumberArray[j] == numberToGuess[i]) {
					guess.incrementCorrectNumbers();					
				}
			}
		}
		return guess;
	}
	
	private Integer[] convertToArray(int number) {
		Integer[] numberArray = new Integer[4];
		for (int i = 3; i > -1; i--) {
			numberArray[i] = number % 10;
			number /= 10;
		}
		return numberArray;
	}
	
}
