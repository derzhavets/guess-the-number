package com.michaniks.gtn.services;

import javax.ejb.Local;

import com.michaniks.gtn.entities.Guess;
import com.michaniks.gtn.helpers.GameNotFoundException;

@Local
public interface GuessService {

	Guess checkGuess(Guess guess) throws GameNotFoundException;

}