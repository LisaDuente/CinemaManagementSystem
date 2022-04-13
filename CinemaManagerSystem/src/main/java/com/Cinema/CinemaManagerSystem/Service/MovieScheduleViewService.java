package com.Cinema.CinemaManagerSystem.Service;

import com.Cinema.CinemaManagerSystem.DataAccessObject.MovieScheduleViewDAO;
import com.Cinema.CinemaManagerSystem.Models.MovieSchedule; // not used? remove?
import com.Cinema.CinemaManagerSystem.Models.MovieScheduleView;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MovieScheduleViewService {
    @Autowired
    MovieScheduleViewDAO dao;

    /**
     * @return gson String of list of all Movie Schedule Views, sends it to DAO class.
     */
    public String downloadWholeView() {
        Gson gson = new Gson();
        ArrayList<MovieScheduleView> arrayList = dao.downloadWholeMovieSchedule();
        return gson.toJson(arrayList);
    }

    /**
     * @param movieName
     * @return gson String with list of all Movie info for one movie using movieName, sends it to DAO class.
     */
    public String downloadAllInfoOneMovie(String movieName) {
        Gson gson = new Gson();
        ArrayList<MovieScheduleView> arrayList = dao.downloadAllInfoForOneMovie(movieName);
        return gson.toJson(arrayList);
    }
}
