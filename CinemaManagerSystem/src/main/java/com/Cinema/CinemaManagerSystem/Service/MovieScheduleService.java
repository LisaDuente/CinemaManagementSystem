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

    /**
     * Sends information to DAO class for Inserting one new Movie Schedule.
     *
     * @param salonId
     * @param movieTime
     * @param movieDate
     * @param movie_Id
     * @param array
     */
    public void insertMovieSchedule(int salonId, String movieTime, String movieDate, int movie_Id, String array) {
        dao.insertMovieSchedule(salonId, movieTime, movieDate, movie_Id, array);
    }

    /**
     * Sends information to DAO class for deleting one Movie Schedule, using movieID.
     *
     * @param movieId
     */
    public void deleteMovieSchedule(int movieId) {
        dao.deleteMovieSchedule(movieId);
    }

    /**
     * Sends information to DAO class for deleting one Movie Schedule, using all parameters
     *
     * @param salonID
     * @param movieTime
     * @param movieDate
     */
    public void deleteMovieScheduleAllParameters(int salonID, String movieTime, String movieDate) {
        dao.deleteMovieSchedule(salonID, movieTime, movieDate);
    }

    /**
     * @param salonID
     * @param movieID
     * @param time
     * @param date
     * @return String from gson regarding one Movie Schedule, sends it to DAO class.
     */
    public String downloadOneMovieSchedule(int salonID, int movieID, String time, String date) {
        Gson gson = new Gson();
        movieSchedule = dao.downloadOneMovieSchedule(salonID, movieID, time, date);
        return gson.toJson(movieSchedule);
    }

    /**
     * @param array
     * @param salonID
     * @param movieID
     * @param time
     * @param date
     * @return String with updated Movie Schedule info, sends it to DAO class.
     */
    public String updateMovieSchedule(String array, int salonID, int movieID, String time, String date) {
        return dao.updateMovieScheduleById(array, salonID, movieID, time, date);
    }

    /**
     * @return String in gson of list of all Movie Schedules, sends it to DAO class.
     */
    public String downloadWholeMovieSchedule() {
        Gson gson = new Gson();
        ArrayList<MovieSchedule> arrayList = dao.downloadWholeMovieSchedule();
        return gson.toJson(arrayList);
    }

}
