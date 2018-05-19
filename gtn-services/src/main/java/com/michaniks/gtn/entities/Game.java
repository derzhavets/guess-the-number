package com.michaniks.gtn.entities;

import static com.michaniks.gtn.helpers.GameStatus.CONTINUES;
import static com.michaniks.gtn.helpers.GameStatus.GUESS_NUMBER_EXCEEDED;
import static com.michaniks.gtn.helpers.GameStatus.WON;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.michaniks.gtn.helpers.GameStatus;
import com.michaniks.gtn.helpers.NumberGenerator;

public class Game {
	
	private final Integer id;
	private final Integer[] numberToGuess;
	private final String playerName;
	
	private GameStatus status;
	
	private List<Guess> guesses = new LinkedList<>();
	
	public Game(Integer id, String playerName) {
		this.id = id;
		this.numberToGuess = NumberGenerator.generateNumberToGuess();
		this.playerName = playerName;
		this.status = GameStatus.CONTINUES;
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
	
	public List<Guess> getGuesses() {
		return guesses;
	}
	
	public GameStatus getStatus() {
		return status;
	}

	public GameStatus updateStatus(Guess guess) {
		if (guesses.size() > 20) {
			return status = GUESS_NUMBER_EXCEEDED;
		} else if (guess.getCorrectPositions() == 4) {
			return status = WON;
		} else {
			return status = CONTINUES;
		}
	}

	public void addGuess(Guess g) {
		guesses.add(g);
	}
	
	@Override
	public String toString() {
		return "Game [id=" + id + ", numberToGuess=" + Arrays.toString(numberToGuess) + ", playerName=" + playerName
				+ "]";
	}
	
}
