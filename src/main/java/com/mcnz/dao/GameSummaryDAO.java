package com.mcnz.dao;

import java.util.Collection;

import com.mcnz.rps.GameSummary;

public interface GameSummaryDAO {
	public void saveGameSummary(GameSummary GameSummary);
	public Collection<GameSummary> getAllGameSummarys();
	public GameSummary getGameSummary(int id);
}
