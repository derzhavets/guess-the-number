package com.michaniks.gtn.entities;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Guess {
	
	@NotNull
	private Integer gameId;
	
	@Min(1000) @Max(9999)
	private int guessedNumber;
	
	private int guessNumber;
	private int correctNumbers;
	private int correctPositions;

	public Guess() {
	}

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

	public void setGuessNumber(int guessNumber) {
		this.guessNumber = guessNumber;
	}

	public int getGuessNumber() {
		return guessNumber;
	}

}
