package com.Cinema.CinemaManagerSystem;

import com.Cinema.CinemaManagerSystem.DataAccessObject.MovieDAO;
import com.Cinema.CinemaManagerSystem.DataAccessObject.ReservationDAO;
import com.Cinema.CinemaManagerSystem.Models.Movie;
import com.Cinema.CinemaManagerSystem.Models.Reservation;
import com.google.gson.Gson;
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

		ArrayList<Movie> movieTest = movieDAO.downloadAllMovies();
		for(Movie movie : movieTest){
			System.out.println(movie.toString());
		}

		Gson gson = new Gson();
		String movieListString = gson.toJson(movieTest);
		System.out.println(movieListString);



		dao.makeReservation("1,2",1,"2",1,"19:00","2022-06-07");


		ReservationDAO dao = context.getBean(ReservationDAO.class);
		ArrayList<Reservation> res = dao.getReservation(6);
		System.out.println(res);
		int x = dao.getLatestReservationID();
		System.out.println(x);
		
		 */

	}
	// erkan cicek java
	// Igor Skarbinski
	// Toros Kutlu
	// Lisa Duente


}


