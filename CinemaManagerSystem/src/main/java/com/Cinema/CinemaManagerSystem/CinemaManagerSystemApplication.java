package com.Cinema.CinemaManagerSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;

@SpringBootApplication
public class CinemaManagerSystemApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(CinemaManagerSystemApplication.class, args);
		MovieDAO movieDAO = context.getBean(MovieDAO.class);

		//movieDAO.deleteMovie(1);
		//movieDAO.insertNewMovie("AdamAndEve","Romance","90 min","Don't eat that apple.");
		//movieDAO.insertNewMovie("Batman","Action / Horror","220 min","Riddler gets devastated!");
		/*
		Movie movie = movieDAO.downloadOneMovie(2);
		System.out.println(movie.toString());
		 */
		ArrayList<Movie> movieTest = movieDAO.downloadAllMovies();
		for(Movie movie : movieTest){
			System.out.println(movie.toString());
		}
	}
	// erkan cicek java
	// Igor Skarbinski
	// Toros Kutlu
	// Lisa Duente


}


