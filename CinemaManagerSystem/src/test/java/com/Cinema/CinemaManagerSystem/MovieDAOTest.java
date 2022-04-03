package com.Cinema.CinemaManagerSystem;

import com.Cinema.CinemaManagerSystem.DataAccessObject.MovieDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
//look into test with spring, this doesn't find any datasource
class MovieDAOTest {
    MovieDAO test;
    @BeforeEach
    public void newEachTime(){
        this.test = new MovieDAO();
    }

    @Test
    void insertNewMovie1() {
        //input
        String name = "Spiderman";
        String genre = "action";
        String duration = "120min";
        String description = "Beware of the Spiderman! Bitten by a spider Peter Parker goes on a big adventure!";
        String shortDescription = "Baw Baw Spiderman";
        String path = "blub";
        //when
        this.test.insertNewMovie(name,genre,duration,description, shortDescription,path);

        //result
        assertEquals("movie added to database",this.test.getError());
    }
}