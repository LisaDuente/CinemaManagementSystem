package com.Cinema.CinemaManagerSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CinemaManagerSystemApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(CinemaManagerSystemApplication.class, args);
		MovieDAO movieDAO = context.getBean(MovieDAO.class);

		movieDAO.insertNewMovie("Batman", "horror", "2h 23min", "Batman kills riddler");
	}
	// erkan cicek java
	// Igor Skarbinski
	// Toros Kutlu
	// Lisa Duente


}


