package com.michaniks.gtn.services.game.classes;

import java.util.concurrent.atomic.AtomicInteger;

public class NumberGenerator {
	
	private final static AtomicInteger uniqueId = new AtomicInteger(1);
	
	public static int generateUniqueId() {
		return uniqueId.getAndIncrement();
	}
	
	public static int[] generateNumberToGuess() {
		int[] n = {1, 2, 3, 17};
		return n;
	}
}
