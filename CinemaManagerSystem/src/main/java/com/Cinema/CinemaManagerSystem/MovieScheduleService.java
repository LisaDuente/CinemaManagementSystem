package com.Cinema.CinemaManagerSystem;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MovieScheduleService {
    @Autowired
    MovieScheduleDAO dao;
    @Autowired
    MovieSchedule movieSchedule;


    public void insertMovieSchedule(String salonId, String movieTime, String movieDate, int movie_Id){
        dao.insertMovieSchedule(salonId, movieTime, movieDate, movie_Id);
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
