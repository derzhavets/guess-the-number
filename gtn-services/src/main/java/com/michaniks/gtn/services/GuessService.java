package com.michaniks.gtn.services;

import javax.ejb.Local;

import com.michaniks.gtn.entities.Guess;

@Local
public interface GuessService {

	Guess checkGuess(Guess guess);

}