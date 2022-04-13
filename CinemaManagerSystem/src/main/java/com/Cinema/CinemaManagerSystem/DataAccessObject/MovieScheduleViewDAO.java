package com.Cinema.CinemaManagerSystem.DataAccessObject;

import com.Cinema.CinemaManagerSystem.Models.MovieScheduleView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Data acess object for the movieScheduleView in database
 */
@Repository
public class MovieScheduleViewDAO {
        @Autowired
        private JdbcTemplate jdbcTemplate;

        public MovieScheduleViewDAO(){
            this.jdbcTemplate = new JdbcTemplate();
        }

    /**
     * gets the whole view from the database
     * @return ArrayList<MovieScheduleView>
     */
    public ArrayList<MovieScheduleView> downloadWholeMovieSchedule(){
            String query = "SELECT * FROM moviescheduleview;";
            ArrayList<MovieScheduleView> movieScheduleViews = new ArrayList<>();
            List<Map<String,Object>> rows = jdbcTemplate.queryForList(query);

            for(Map<String, Object> row : rows){
                MovieScheduleView movieSchV = new MovieScheduleView(
                        (int) row.get("Salon"),
                        String.valueOf(row.get("Time")),
                        String.valueOf(row.get("Date")),
                        String.valueOf(row.get("Movie"))
                );
                movieScheduleViews.add(movieSchV);
            }

            return movieScheduleViews;
        }

    /**
     * gets all entries for one specific movie from MovieScheduleView by name
     * @param movieName String
     * @return ArrayList<MovieScheduleView>
     */
    public ArrayList<MovieScheduleView> downloadAllInfoForOneMovie(String movieName){
            String query = "SELECT * FROM moviescheduleview WHERE Movie = ?;";
            ArrayList<MovieScheduleView> movieScheduleViews = new ArrayList<>();
            List<Map<String,Object>> rows = jdbcTemplate.queryForList(query, movieName);

            for(Map<String, Object> row : rows){
                MovieScheduleView movieSchV = new MovieScheduleView(
                        (int) row.get("Salon"),
                        String.valueOf(row.get("Time")),
                        String.valueOf(row.get("Date")),
                        String.valueOf(row.get("Movie"))
                );
                movieScheduleViews.add(movieSchV);
            }

            return movieScheduleViews;
        }

}
