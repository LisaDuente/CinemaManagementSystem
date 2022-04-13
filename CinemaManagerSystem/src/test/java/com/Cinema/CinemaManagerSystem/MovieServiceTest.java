package com.Cinema.CinemaManagerSystem;

import com.Cinema.CinemaManagerSystem.DataAccessObject.MovieDAO;
import com.Cinema.CinemaManagerSystem.Models.Movie;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

// Toros
// Incomplete
class MovieServiceTest {

    @Autowired
    MovieDAO dao;
    Movie movie;
    ArrayList<Movie> movies;

    @Test
    void downloadOneMovie() {
    }

    public String downloadOneMovie(int id){
        Gson gson = new Gson();
        movie = dao.downloadOneMovie(id);
        String movieString = gson.toJson(movie);
        return movieString;
    }

    // Incomplete
    @Test
    void downloadOneMovieTest01() {
        String s = downloadOneMovie(1);
        assertEquals(s, "1");
    }

    @Test
    void insertMovie() {
    }

    @Test
    void updateMovie() {
    }

    @Test
    void deleteMovie() {
    }

    @Test
    void downloadAllMovies() {
    }

    @Test
    void downloadMostRecent() {
    }
}