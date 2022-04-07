package com.Cinema.CinemaManagerSystem.DataAccessObject;

import com.Cinema.CinemaManagerSystem.Models.Employee;
import com.Cinema.CinemaManagerSystem.Models.MovieSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class MovieScheduleDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private String error;

    public MovieScheduleDAO(){
        this.error = "no";
        this.jdbcTemplate = new JdbcTemplate();
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

        int result = jdbcTemplate.update(query, salonId, movieTime, movieDate, movieId, array);

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
        int result = jdbcTemplate.update(query, movieId);

        if(result > 0){
            System.out.println(result + " movieSchedule deleted from database");
            this.error = "movieSchedule deleted from database";
        }
    }

    public void deleteMovieSchedule(int salonID, String movieTime, String movieDate){
        String query = "DELETE FROM movie_schedule WHERE movie_ID = ? AND salon_ID = ? AND movie_time = ? AND movie_date = ?";
        int result = jdbcTemplate.update(query, salonID,movieTime,movieDate);

        if(result > 0){
            System.out.println(result + " movieSchedule deleted from database");
            this.error = "movieSchedule deleted from database";
        }
    }

    public String updateMovieScheduleById(String array, int salonID, int movieID, String time, String date){
        String query = "update movie_schedule set movie_schedule.seatsOfArrayForMovie = ? where salon_ID = ? and movie_ID = ? and movie_time = ? and movie_date = ?";
        int result = jdbcTemplate.update(query, array, salonID, movieID, time, date);
        if (result > 0 ){
            System.out.println("nice");
        }
        return "nice mmm nice";
    }


    public MovieSchedule downloadOneMovieSchedule(int salonID, int movieID, String time, String date){
        String query = "select * from movie_schedule where salon_ID = ? and movie_ID = ? and movie_time = ? and movie_date = ?";
        return jdbcTemplate.queryForObject(query, (rs, rowNum) -> new MovieSchedule(
                rs.getInt("salon_ID"),
                rs.getString("movie_time"),
                rs.getString("movie_date"),
                rs.getInt("movie_ID"),
                rs.getString("seatsOfArrayForMovie"),
                true
        ), salonID, movieID, time, date);
    }

    public ArrayList<MovieSchedule> downloadWholeMovieSchedule(){
        String query = "SELECT * FROM movie_schedule;";
        ArrayList<MovieSchedule> movie_schedule = new ArrayList<>();
        List<Map<String,Object>> rows = jdbcTemplate.queryForList(query);

        for(Map<String, Object> row : rows){
            MovieSchedule movieSch = new MovieSchedule(
                    (int) (long) row.get("salon_ID"),
                    String.valueOf(row.get("movie_time")),
                    String.valueOf(row.get("movie_date")),
                    (int) (long) row.get("movie_ID"),
                    String.valueOf(row.get("seatsOfArrayForMovie")),
                    true
                    );
            movie_schedule.add(movieSch);
        }

        return movie_schedule;
    }
}
