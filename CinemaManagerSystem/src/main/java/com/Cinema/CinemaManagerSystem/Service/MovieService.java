package com.Cinema.CinemaManagerSystem.Service;

import com.Cinema.CinemaManagerSystem.Models.Movie;
import com.Cinema.CinemaManagerSystem.DataAccessObject.MovieDAO;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MovieService {
    @Autowired
    MovieDAO dao;
    Movie movie;
    ArrayList<Movie> movies;

    /**
     * Sends information to DAO class for inserting one new movie.
     *
     * @param name
     * @param genre
     * @param duration
     * @param movieDescription
     * @param shortDescription
     * @param path
     */
    public void insertMovie(String name, String genre, String duration, String movieDescription, String shortDescription, String path) {
        dao.insertNewMovie(name, genre, duration, movieDescription, shortDescription, path);
    }

    /**
     * Sends information to DAO class for updating one movie.
     *
     * @param id
     * @param name
     * @param genre
     * @param duration
     * @param movieDescription
     * @param shortDescription
     * @param path
     */
    public void updateMovie(int id, String name, String genre, String duration, String movieDescription, String shortDescription, String path) {
        dao.updateMovie(id, name, genre, duration, movieDescription, shortDescription, path);
    }

    /**
     * Sends information to DAO class for deleting one movie using movieID
     *
     * @param idDelete
     */
    public void deleteMovie(int idDelete) {
        dao.deleteMovie(idDelete);
    }

    /**
     * @param id
     * @return gson String regarding info about one movie, based on movieID, sends it to DAO class.
     */
    public String downloadOneMovie(int id) {
        Gson gson = new Gson();
        movie = dao.downloadOneMovie(id);
        String movieString = gson.toJson(movie);
        return movieString;
    }

    /**
     * @return gson String with information regarding all movies, sends it to DAO class.
     */
    public String downloadAllMovies() {
        movies = dao.downloadAllMovies();
        Gson gson = new Gson();
        String movieListString = gson.toJson(movies);
        return movieListString;
    }

    /**
     * assigns to 'movie' object, the movie with highest movieID, by using the newlyAddedMovie() method, then...
     * returns a gson String with information regarding this most recently added movie to the DAO class.
     *
     * @return please see above.
     */
    public String downloadMostRecent() {
        movie = dao.newlyAddedMovie();
        Gson gson = new Gson();
        return gson.toJson(movie);
    }

    public String downloadMovieByName(String name){
        return dao.downloadMovieByName(name);
    }
}