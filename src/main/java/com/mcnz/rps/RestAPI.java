package com.mcnz.rps;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

/*
To run the RestAPI the URL should be http://localhost:8080/score

This project was tested with Gradle 6.6.1. If in doubt, check your Gradle version in both Eclipse and at the command line.

gradle --version

 */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mcnz.dao.GameSummaryDAO;

@CrossOrigin  //Enable this to allow the APIs to be invoked from a webpage with a different domain name
@RestController
public class RestAPI {
	
	@Autowired
	private GameSummaryDAO gameSummaryDAO;
	
	@CrossOrigin
	@GetMapping("/gamesummary")
	public Collection<GameSummary> getGameSummarys() {
		return gameSummaryDAO.getAllGameSummarys();
	}
	
	public static Score score = new Score();
	@CrossOrigin
	@GetMapping({"/", "/score"})
	public Score getScore() {
		return score;
	}
	@CrossOrigin
	@GetMapping("/score/increasewins")
	public int increasewins() {
		return score.wins++;
	}
	@CrossOrigin
	@GetMapping("/score/increaselosses")
	public int increaselosses() {
		return score.losses++;
	}
	@CrossOrigin
	@GetMapping("/score/increaseties")
	public int increaseties() {
		return score.ties++;
	}
	@CrossOrigin
	@GetMapping("/score/wins")
	public int getWins() {
		return score.wins;
	}
	@CrossOrigin
	@GetMapping("/score/losses")
	public int getLosses() {
		return score.losses;
	}
	@CrossOrigin
	@GetMapping("/score/ties")
	public int getTies() {
		return score.ties;
	}
	

	

	
}

