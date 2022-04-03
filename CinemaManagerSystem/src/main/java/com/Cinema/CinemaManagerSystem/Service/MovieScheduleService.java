package com.Cinema.CinemaManagerSystem.Service;

import com.Cinema.CinemaManagerSystem.Models.MovieSchedule;
import com.Cinema.CinemaManagerSystem.DataAccessObject.MovieScheduleDAO;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MovieScheduleService {
    @Autowired
    MovieScheduleDAO dao;
    MovieSchedule movieSchedule;


    public void insertMovieSchedule(int salonId, String movieTime, String movieDate, int movie_Id, String array){
        dao.insertMovieSchedule(salonId, movieTime, movieDate, movie_Id, array);
    }

    public void deleteMovieSchedule(int movieId){
        dao.deleteMovieSchedule(movieId);
    }

    public String downloadOneMovieSchedule(int movieId){
        Gson gson = new Gson();
        movieSchedule = dao.downloadOneMovieSchedule(movieId);
        String movieString = gson.toJson(movieSchedule);
        return movieString;
    }
}
