package com.mcnz.dao;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DaoConfig {
	
	@Bean
	JdbcTemplate jdbcTemplate(DataSource ds) {
	  return new JdbcTemplate(ds);
	}

}
