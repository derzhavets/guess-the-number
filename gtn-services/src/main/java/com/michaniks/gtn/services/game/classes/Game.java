package com.michaniks.gtn.services.game.classes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Game {
	
	private final Integer id;
	private final int[] numberToGuess;
	private final String playerName;
	
	private List<Guess> guesses = new LinkedList<>();
	
	public Game(Integer id, String playerName) {
		this.id = id;
		this.numberToGuess = NumberGenerator.generateNumberToGuess();
		this.playerName = playerName;
	}

	public int[] getNumberToGuess() {
		return numberToGuess;
	}

	public String getPlayerName() {
		return playerName;
	}

	public Integer getId() {
		return id;
	}
	
}
