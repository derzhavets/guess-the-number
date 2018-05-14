package com.michaniks.gtn.services.game.classes;

public class Game {
	
	private final int[] numberToGuess;
	private final String playerName;
	
	public Game(String playerName) {
		this.numberToGuess = NumberGenerator.generateNumberToGuess();
		this.playerName = playerName;
	}

	public int[] getNumberToGuess() {
		return numberToGuess;
	}

	public String getPlayerName() {
		return playerName;
	}
	
}
