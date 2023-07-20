package com.mcnz.rps;

/*
To run the RestAPI the URL should be http://localhost:8080/score

This project was tested with Gradle 6.6.1. If in doubt, check your Gradle version in both Eclipse and at the command line.

gradle --version

 */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin  Enable this to allow the APIs to be invoked from a webpage with a different domain name
@RestController
public class RestAPI {
	
	public static Score score = new Score();
	
	@GetMapping("/score")
	public Score getScore() {
		return score;
	}
	
	@GetMapping("/score/increasewins")
	public int increasewins() {
		return score.wins++;
	}
	
	@GetMapping("/score/increaselosses")
	public int increaselosses() {
		return score.losses++;
	}
	
	@GetMapping("/score/increaseties")
	public int increaseties() {
		return score.losses++;
	}
	
	@GetMapping("/score/wins")
	public int getWins() {
		return score.wins++;
	}
	
	@GetMapping("/score/losses")
	public int getLosses() {
		return score.losses++;
	}
	
	@GetMapping("/score/ties")
	public int getTies() {
		return score.losses++;
	}
}

