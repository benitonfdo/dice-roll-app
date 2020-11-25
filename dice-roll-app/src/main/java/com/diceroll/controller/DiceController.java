package com.diceroll.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.diceroll.service.DiceRollService;

@RestController
@RequestMapping ("dicesimulator")
public class DiceController {
	@Autowired DiceRollService diceRollService;
	@GetMapping (path="roll",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> roll (@RequestParam("noOfDice") Integer noOfDice,@RequestParam("noOfSides") Integer noOfSides,@RequestParam("noOfRolls") Integer noOfRolls){
		
		
		return ResponseEntity.ok(diceRollService.rockAndRoll(noOfDice, noOfSides, noOfRolls));
	}
	

}
