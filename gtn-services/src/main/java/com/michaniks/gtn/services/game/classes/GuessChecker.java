package com.michaniks.gtn.services.game.classes;

public class GuessChecker {
	
	public static Guess checkGuess(Guess guess) {
		int[] guessedNumberArray = convertToArray(guess.getGuessedNumber());
		populateGuess(guess);
		return guess;
	}
	
	private static int[] convertToArray(int number) {
		return new int[] {6,6,6,6};
	}
	
	private static Guess populateGuess(Guess guess) {
		guess.setCorrectNumbers(2);
		guess.setCorrectPositions(1);
		return guess;
	}
}
