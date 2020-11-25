package com.diceroll.service;

import com.diceroll.model.DiceRollResponse;

public interface DiceRollService {
	
	public DiceRollResponse rockAndRoll(int noOfDice, int sides, int timesRolled );

}
