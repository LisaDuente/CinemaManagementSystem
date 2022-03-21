package com.Cinema.CinemaManagerSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CinemaManagerSystemApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(CinemaManagerSystemApplication.class, args);
		MovieDAO movieDAO = context.getBean(MovieDAO.class);

		//movieDAO.deleteMovie(1);
		movieDAO.insertNewMovie("Spiderman","Action","120 min","Pow pow Spiderman");
		Movie movie = movieDAO.downloadOneMovie(2);
		System.out.println(movie.toString());
	}
	// erkan cicek java
	// Igor Skarbinski
	// Toros Kutlu
	// Lisa Duente


}


