package com.Cinema.CinemaManagerSystem.DataAccessObject;

import com.Cinema.CinemaManagerSystem.Models.MovieSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class MovieScheduleDAO {
    @Autowired
    private JdbcTemplate jdcbTemplate;
    private String error;

    public MovieScheduleDAO(){
        this.error = "no";
        this.jdcbTemplate = new JdbcTemplate();
    }

    /**
     * method to insert a new movie_schedule into the database
     * @param salonId String - salon in the cinema
     * @param movieTime String - when movie starts
     * @param movieDate String - which date movie starts
     * @param movieId int - which movie
     */
    public void insertMovieSchedule(int salonId, String movieTime, String movieDate, int movieId, String array){
        String query = "INSERT INTO movie_schedule VALUES(?,?,?,?,?);";

        int result = jdcbTemplate.update(query, salonId, movieTime, movieDate, movieId, array);

        if(result > 0){
            System.out.println(result + " movieSchedule added to database");
            this.error = "movieSchedule added to database";
        }
    }

    /**
     * method to delete a movie schedule from database
     * @param movieId int for movie_ID of movie we want to delete from movie schedule
     */
    public void deleteMovieSchedule(int movieId){
        String query = "DELETE FROM movie_schedule WHERE movie_ID = ?";
        int result = jdcbTemplate.update(query, movieId);

        if(result > 0){
            System.out.println(result + " movieSchedule deleted from database");
            this.error = "movieSchedule deleted from database";
        }
    }

    public String updateMovieScheduleById(String array, int salonID, int movieID, String time, String date){
        String query = "update movie_schedule set movie_schedule.seatsOfArrayForMovie = ? where salon_ID = ? and movie_ID = ? and movie_time = ? and movie_date = ?";
        int result = jdcbTemplate.update(query, array, salonID, movieID, time, date);
        if (result > 0 ){
            System.out.println("nice");
        }
        return "nice mmm nice";
    }


    public MovieSchedule downloadOneMovieSchedule(int salonID, int movieID, String time, String date){
        String query = "select * from movie_schedule where salon_ID = ? and movie_ID = ? and movie_time = ? and movie_date = ?";
        return jdcbTemplate.queryForObject(query, (rs, rowNum) -> new MovieSchedule(
                rs.getInt("salon_ID"),
                rs.getString("movie_time"),
                rs.getString("movie_date"),
                rs.getInt("movie_ID"),
                rs.getString("seatsOfArrayForMovie"),
                true
        ), salonID, movieID, time, date);
    }
}
