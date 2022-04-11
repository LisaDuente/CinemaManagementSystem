package com.Cinema.CinemaManagerSystem.DataAccessObject;

import com.Cinema.CinemaManagerSystem.Models.MovieSchedule;
import com.Cinema.CinemaManagerSystem.Models.MovieScheduleView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class MovieScheduleViewDAO {
        @Autowired
        private JdbcTemplate jdbcTemplate;

        public MovieScheduleViewDAO(){
            this.jdbcTemplate = new JdbcTemplate();
        }

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
