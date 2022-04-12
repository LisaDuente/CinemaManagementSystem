package com.Cinema.CinemaManagerSystem.Service;

import com.Cinema.CinemaManagerSystem.DataAccessObject.MovieScheduleViewDAO;
import com.Cinema.CinemaManagerSystem.Models.MovieSchedule;
import com.Cinema.CinemaManagerSystem.Models.MovieScheduleView;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MovieScheduleViewService {
    @Autowired
    MovieScheduleViewDAO dao;

    public String downloadWholeView(){
        Gson gson = new Gson();
        ArrayList<MovieScheduleView> arrayList= dao.downloadWholeMovieSchedule();
        return gson.toJson(arrayList);
    }

    public String downloadAllInfoOneMovie(String movieName){
        Gson gson = new Gson();
        ArrayList<MovieScheduleView> arrayList= dao.downloadAllInfoForOneMovie(movieName);
        return gson.toJson(arrayList);
    }
}
