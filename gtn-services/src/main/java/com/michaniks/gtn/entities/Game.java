package com.michaniks.gtn.entities;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.michaniks.gtn.helpers.NumberGenerator;

public class Game {
	
	private final Integer id;
	private final Integer[] numberToGuess;
	private final String playerName;
	
	private List<Guess> guesses = new LinkedList<>();
	
	public Game(Integer id, String playerName) {
		this.id = id;
		this.numberToGuess = NumberGenerator.generateNumberToGuess();
		this.playerName = playerName;
	}

	public Integer[] getNumberToGuess() {
		return numberToGuess;
	}

	public String getPlayerName() {
		return playerName;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", numberToGuess=" + Arrays.toString(numberToGuess) + ", playerName=" + playerName
				+ "]";
	}
	
}
