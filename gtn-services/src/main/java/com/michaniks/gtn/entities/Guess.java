package com.michaniks.gtn.entities;

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
	
	public void incrementCorrectNumbers() {
		this.correctNumbers++;
	}

	public void incrementCorrectPositions() {
		correctPositions++;
	}

	public Integer getGameId() {
		return gameId;
	}
	
}
