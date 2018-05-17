package com.michaniks.gtn.helpers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberGenerator {
	
	private final static AtomicInteger uniqueId = new AtomicInteger(1);
	
	public static int generateUniqueId() {
		return uniqueId.getAndIncrement();
	}
	
	public static Integer[] generateNumberToGuess() {
		List<Integer> range = IntStream.range(1, 10).boxed()
		        .collect(Collectors.toCollection(ArrayList::new));
		Collections.shuffle(range);
		return range.subList(0, 4).toArray(new Integer[0]);
	}
}
