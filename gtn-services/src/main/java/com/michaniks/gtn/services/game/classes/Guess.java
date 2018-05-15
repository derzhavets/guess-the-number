package com.michaniks.gtn.services.game.classes;

public class Guess {
	
	private final int guessedNumber;
	private final int correctNumbers;
	private final int correctPositions;
	
	public Guess(int guessedNumber, int correctNumbers, int correctPositions) {
		this.guessedNumber = guessedNumber;
		this.correctNumbers = correctNumbers;
		this.correctPositions = correctPositions;
	}

	public int getGuessedNumber() {
		return guessedNumber;
	}
	
	public int getCorrectNumbers() {
		return correctNumbers;
	}

	public int getCorrectPositions() {
		return correctPositions;
	}

	
}
