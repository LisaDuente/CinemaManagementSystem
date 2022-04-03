package com.Cinema.CinemaManagerSystem.DataAccessObject;

import com.Cinema.CinemaManagerSystem.Models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
//everyone needs to create a database with User + Pass from properties,
//don't forget to set all privileges
@Repository
public class MovieDAO {
    @Autowired
    private JdbcTemplate jdcbTemplate;
    private String error;

    public MovieDAO(){
        this.error = "no";
        this.jdcbTemplate = new JdbcTemplate();
    }

    /**
     * method to insert a new Movie into the database
     * @param name String - name of movie
     * @param genre String - genre
     * @param duration String - duration in minutes and hours
     * @param description String - not longer than 255 characters
     */
    public void insertNewMovie(String name, String genre, String duration, String description, String shortDescription, String path){

        //should we insert null here to generate a new id with auto_increment in MySQL?
        String query = "INSERT INTO movie VALUES(null,?,?,?,?,?,?);";

        int result = jdcbTemplate.update(query, name, genre, duration, description,shortDescription,path);

        if(result > 0){
            System.out.println(result + " movie added to database");
            this.error = "movie added to database";
        }
    }

    /**
     * method to delete a movie from database
     * @param id int for movie_id of movie we want to delete
     */
    public void deleteMovie(int id){
        String query = "DELETE FROM movie WHERE movie_ID = ?";
        int result = jdcbTemplate.update(query, id);

        if(result > 0){
            System.out.println(result + " movie deleted from database");
            this.error = "movie deleted from database";
        }
    }


    public Movie downloadOneMovie(int id){

        String query = "SELECT * FROM movie WHERE movie_id = ?";
        return this.jdcbTemplate.queryForObject(query, new RowMapper<Movie>() {
            @Override
            public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
                Movie innerMovie = new Movie(
                        rs.getInt("movie_id"),
                        rs.getString("movie_name"),
                        rs.getString("genre"),
                        rs.getString("duration"),
                        rs.getString("short_description"),
                        rs.getString("movie_description"),
                        rs.getString("picture_path"),
                        true);
                return innerMovie;
            }
        }, id);
    }

    /**
     * downloads all movies from the database
     * @return ArrayList<Movie>
     */

    public ArrayList<Movie> downloadAllMovies(){
        String query = "SELECT * FROM movie";
        ArrayList<Movie> movies = new ArrayList<>();
        List<Map<String,Object>> rows = jdcbTemplate.queryForList(query);

        for(Map<String, Object> row : rows){
            Movie movie = new Movie(
                    (int) (long) row.get("movie_id"),
                    String.valueOf(row.get("movie_name")),
                    String.valueOf(row.get("genre")),
                    String.valueOf(row.get("duration")),
                    String.valueOf(row.get("short_description")),
                    String.valueOf(row.get("movie_description")),
                    String.valueOf(row.get("picture_path")),
                    true);
            movies.add(movie);
        }
        movies.sort(Comparator.comparing(Movie::getName));

        return movies;
    }



    /**
     * Method to download the movie with the highest id, meaning its new and should be on our frontpage as a recommendation
     */
    public Movie newlyAddedMovie(){ //Erkan
        String query = "SELECT * FROM movie WHERE movie_ID = (SELECT MAX(movie_id) FROM movie);";
        Movie temp = jdcbTemplate.queryForObject(query, (rs, rowNum) -> {
            Movie movie = new Movie(rs.getInt("movie_id"),
                    rs.getString("movie_name"),
                    rs.getString("genre"),
                    rs.getString("duration"),
                    rs.getString("short_description"),
                    rs.getString("movie_description"),
                    rs.getString("picture_path"),
                    true);
            return movie;
        });
        return temp;
    }


    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
