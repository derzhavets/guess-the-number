package com.michaniks.gtn.services.game.classes;

public class Guess {
	
	private Integer gameId;
	private int guessedNumber;
	private int correctNumbers;
	private int correctPositions;
	
	public Guess() {}

	public Guess(Integer gameId) {
		this.gameId = gameId;
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

	public void setGuessedNumber(int guessedNumber) {
		this.guessedNumber = guessedNumber;
	}

	public void setCorrectNumbers(int correctNumbers) {
		this.correctNumbers = correctNumbers;
	}

	public void setCorrectPositions(int correctPositions) {
		this.correctPositions = correctPositions;
	}

	public Integer getGameId() {
		return gameId;
	}
	
}
