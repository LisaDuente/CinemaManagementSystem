package com.Cinema.CinemaManagerSystem.DataAccessObject;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

class MovieDAOTest {

    /*
    @Test
    void insertNewMovie("Trust No One", "Documentary", "1h 20min", "Mystery...", "Open ended...", "BLOB") {
        /*
        public void insertNewMovie(String name, String genre, String duration, String description, String shortDescription, String path){

        //should we insert null here to generate a new id with auto_increment in MySQL?
        String query = "INSERT INTO movie VALUES(null,?,?,?,?,?,?);";

        int result = jdcbTemplate.update(query, name, genre, duration, description,shortDescription,path);

        if(result > 0){
            System.out.println(result + " movie added to database");
            this.error = "movie added to database";
        }
    }

        //assertEquals(result > 0, );
    }
    */

    @Test
    void deleteMovie() {
    }

    @Test
    void downloadOneMovie() {
    }

    @Test
    void downloadAllMovies() {
    }

    @Test
    void newlyAddedMovie() {
    }

    @Test
    void getError() {
    }

    @Test
    void setError() {
    }
}