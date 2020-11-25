package com.diceroll.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import com.diceroll.model.DiceRollResponse;
import com.diceroll.model.DiceRollResult;

@Service
public class DiceRollServiceImpl implements DiceRollService{
	
	public DiceRollResponse rockAndRoll(int noOfDice, int sides, int timesRolled ) {

		// Inclusive
		int minRange = 1;
		// Exclusive
		int maxRange = sides + 1;
		DiceRollResponse response = new DiceRollResponse();
		Map<Integer, Integer> noOfSimilarResults = new ConcurrentHashMap<>();
		IntStream.range(0, timesRolled).parallel().forEach(rollIndex -> {
			//System.out.println("Rolling ...: " + rollIndex);
			int sum = ThreadLocalRandom.current().ints(noOfDice, minRange, maxRange).sum();
			//System.out.println("Summation of rolls: " + sum);
			noOfSimilarResults.merge(sum, 1, Integer::sum);	
			
			
		});
		noOfSimilarResults.entrySet().stream().forEach(entry -> { 
			response.getResults().add(new DiceRollResult(entry.getKey(), entry.getValue()));
		});
		System.out.println(noOfSimilarResults);
		Integer totalRuns = noOfSimilarResults.values().stream().mapToInt(value -> value).sum();
		System.out.println(totalRuns == timesRolled);
		return response;
	}

	 
}
