package com.mcnz.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;

@Profile("cameron")
@SpringBootApplication
@ComponentScan(basePackages = { "com.mcnz", "com.mcnz.project"} )
public class AwesomeSpringApp {

	public static void main(String[] args) {
		SpringApplication.run(AwesomeSpringApp.class, args);
	}

}
