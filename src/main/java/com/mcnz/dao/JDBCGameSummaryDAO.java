package com.mcnz.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mcnz.rps.GameSummary;


@Repository
public class JDBCGameSummaryDAO implements GameSummaryDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void saveGameSummary(GameSummary gameSummary) {
        String sql = "INSERT INTO GAMESUMMARY (CLIENTGESTURE, SERVERGESTURE, RESULTS, DATE) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, gameSummary.getClientGesture(), gameSummary.getServerGesture(), gameSummary.getResult(), gameSummary.getTimePlayed());
	}

	@Override
	public Collection<GameSummary> getAllGameSummarys() {
		// Replace this statement with the call to jdbcTemplate.
		
		return jdbcTemplate.query("Select * from GAMESUMMARY", new
				BeanPropertyRowMapper<GameSummary>(GameSummary.class));
	}

	@Override
	public GameSummary getGameSummary(int id) {
		String sql = "SELECT * FROM GAMESUMMARY WHERE id = ?";
		List<GameSummary> gameSummarys = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(GameSummary.class), id);
		return gameSummarys.isEmpty() ? null : gameSummarys.get(0);
	}

}
