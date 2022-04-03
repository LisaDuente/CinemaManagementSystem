package com.Cinema.CinemaManagerSystem.Controller;

import com.Cinema.CinemaManagerSystem.Service.MovieScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieScheduleController {

    @Autowired
    MovieScheduleService movieScheduleService;

    public MovieScheduleController(MovieScheduleService movieScheduleService) {
        this.movieScheduleService = movieScheduleService;}

    @GetMapping("/insertMovieSchedule")
    public void insertMovieSchedule(@RequestParam(value = "salonId", defaultValue = "NoSalonId") int salonId,
                                   @RequestParam(value = "movieTime", defaultValue = "NoMovieTime") String movieTime,
                                   @RequestParam(value = "movieDate", defaultValue = "noMovieDate") String movieDate,
                                   @RequestParam(value = "movieId", defaultValue = "-1") int movieId,
                                   @RequestParam(value = "seatsData") String seatsData){
        movieScheduleService.insertMovieSchedule(salonId, movieTime, movieDate, movieId, seatsData);
    }

    @GetMapping("/deleteMovieSchedule")
    public void deleteMovieSchedule(@RequestParam(value = "movieId", defaultValue = "-1") int movieId){
        movieScheduleService.deleteMovieSchedule(movieId);
    }

    @GetMapping("/downloadOneMovieSchedule")
    public String downloadOneMovieSchedule(@RequestParam(value = "movieId", defaultValue = "-1") int movieId){
        return movieScheduleService.downloadOneMovieSchedule(movieId);
    }
}
