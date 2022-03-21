package com.Cinema.CinemaManagerSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MovieDAO {
    @Autowired
    private JdbcTemplate jdcbTemplate;
    private String error;

    public MovieDAO(){
        this.error = "no";
        this.jdcbTemplate = new JdbcTemplate();
    }

    public void insertNewMovie(String name, String genre, String duration, String description){

        //should we insert null here to generate a new id with auto_increment in MySQL?
        String query = "INSERT INTO movie VALUES(null,?,?,?,?);";

        int result = jdcbTemplate.update(query, name, genre, duration, description);

        if(result > 0){
            System.out.println(result + "movie added to database");
            this.error = "movie added to database";
        }
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
