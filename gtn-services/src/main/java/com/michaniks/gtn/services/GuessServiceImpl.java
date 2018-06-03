package com.michaniks.gtn.services;

import static com.michaniks.gtn.helpers.GameStatus.CONTINUES;
import static com.michaniks.gtn.helpers.GameStatus.WON;
import static com.michaniks.gtn.helpers.GameStatus.WON_AND_SAVED;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.michaniks.gtn.dao.GameDAO;
import com.michaniks.gtn.dao.ScoresDAO;
import com.michaniks.gtn.entities.Game;
import com.michaniks.gtn.entities.Guess;
import com.michaniks.gtn.entities.Score;
import com.michaniks.gtn.helpers.GameNotFoundException;
import com.michaniks.gtn.helpers.GameStatus;

@Stateless
public class GuessServiceImpl implements GuessService {

	@EJB
	private GameDAO gameDao;

	@EJB
	private ScoresDAO scoresDao;

	@Override
	public Guess checkGuess(Guess guess) throws GameNotFoundException {
		Game game = gameDao.getGame(guess.getGameId());
		checkNumberAndUpdateGuess(game, guess);
		if (game.getStatus() == CONTINUES) {
			GameStatus.update(game, guess);
			game.addGuess(guess);
			guess.setGuessNumber(game.getGuesses().indexOf(guess) + 1);
		}
		if (game.getStatus() == WON) {
			scoresDao.save(new Score(game.getPlayerName(), game.getGuesses().size()));
			game.setStatus(WON_AND_SAVED);
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
