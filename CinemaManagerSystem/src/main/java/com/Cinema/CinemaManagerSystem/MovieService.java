package com.Cinema.CinemaManagerSystem;

import com.Cinema.CinemaManagerSystem.Movie;
import com.Cinema.CinemaManagerSystem.MovieDAO;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class MovieService {
    @Autowired
    MovieDAO dao;
    Movie movie;
    ArrayList<Movie> movies;

    public void insertMovie(String name, String genre, String duration, String movieDescription, String shortDescription, String path) {
        dao.insertNewMovie(name, genre, duration, movieDescription, shortDescription, path);
    }

    public void deleteMovie(int idDelete){
        dao.deleteMovie(idDelete);
    }

    public String downloadOneMovie(int id){
        Gson gson = new Gson();
        movie = dao.downloadOneMovie(id);
        String movieString = gson.toJson(movie);
        return movieString;
    }

    public String downloadAllMovies(){
        movies = dao.downloadAllMovies();
        Gson gson = new Gson();
        String movieListString = gson.toJson(movies);
        return movieListString;
    }

    public String downloadMostRecent(){
        movie = dao.newlyAddedMovie();
        Gson gson = new Gson();
        return gson.toJson(movie);
    }

}