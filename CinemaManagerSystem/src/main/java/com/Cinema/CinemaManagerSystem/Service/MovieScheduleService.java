package com.Cinema.CinemaManagerSystem.Service;

import com.Cinema.CinemaManagerSystem.Models.MovieSchedule;
import com.Cinema.CinemaManagerSystem.DataAccessObject.MovieScheduleDAO;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


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

    public void deleteMovieScheduleAllParameters( int salonID, String movieTime, String movieDate){
        dao.deleteMovieSchedule(salonID,movieTime,movieDate);
    }

    public String downloadOneMovieSchedule(int salonID, int movieID, String time, String date){
        Gson gson = new Gson();
        movieSchedule = dao.downloadOneMovieSchedule(salonID,movieID, time, date);
        return gson.toJson(movieSchedule);
    }

    public String updateMovieSchedule(String array, int salonID, int movieID, String time, String date){
        return dao.updateMovieScheduleById(array, salonID, movieID, time, date);
    }

    public String downloadWholeMovieSchedule(){
        Gson gson = new Gson();
        ArrayList<MovieSchedule> arrayList= dao.downloadWholeMovieSchedule();
        return gson.toJson(arrayList);
    }
}
