package com.Cinema.CinemaManagerSystem.Controller;

import com.Cinema.CinemaManagerSystem.Service.MovieScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MovieScheduleController {

    @Autowired
    MovieScheduleService movieScheduleService;

    public MovieScheduleController(MovieScheduleService movieScheduleService) {
        this.movieScheduleService = movieScheduleService;}

    @PostMapping("/insertMovieSchedule")
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

    @DeleteMapping("/deleteMovieAllParameters")
    public void deleteMovieAllParameters(@RequestParam(value = "salonID", defaultValue = "-1")int salonID,
                                         @RequestParam(value = "movieTime", defaultValue = "-1")String movieTime,
                                         @RequestParam(value = "movieDate", defaultValue = "-1")String movieDate){
        this.movieScheduleService.deleteMovieScheduleAllParameters(salonID,movieTime,movieDate);

    }

    @PostMapping("/updateMovieSchedule")
    public String updateMovieSchedule(
            @RequestParam("seats") String array,
            @RequestParam("salonID") int salonID,
            @RequestParam(value = "movieID", defaultValue = "-1") int movieID,
            @RequestParam("time")String time,
            @RequestParam("date") String date
    ){
        return movieScheduleService.updateMovieSchedule(array, salonID, movieID, time, date);
    }

    @GetMapping("/downloadOneMovieSchedule")
    public String downloadOneMovieSchedule(
            @RequestParam("salonID") int salonID,
            @RequestParam(value = "movieID", defaultValue = "-1") int movieID,
            @RequestParam("time")String time,
            @RequestParam("date") String date){
        return movieScheduleService.downloadOneMovieSchedule(salonID, movieID, time,date);
    }

    @GetMapping("/downloadWholeMovieSchedule")
    public String downloadWholeMovieSchedule(){
        return movieScheduleService.downloadWholeMovieSchedule();
    }
}
