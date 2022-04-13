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
    /**
     * Sends request to insert a new movieSchedule to database
     * @param salonId int for salonID of salon
     * @param movieTime time when the movie starts
     * @param movieDate date when the movie is playing
     * @param movieId what movie is playing
     * @param seatsData seatsOfArrayForMovie, how many seats in the salon
     */
    @PostMapping("/insertMovieSchedule")
    public void insertMovieSchedule(@RequestParam(value = "salonId", defaultValue = "NoSalonId") int salonId,
                                   @RequestParam(value = "movieTime", defaultValue = "NoMovieTime") String movieTime,
                                   @RequestParam(value = "movieDate", defaultValue = "noMovieDate") String movieDate,
                                   @RequestParam(value = "movieId", defaultValue = "-1") int movieId,
                                   @RequestParam(value = "seatsData") String seatsData){
        movieScheduleService.insertMovieSchedule(salonId, movieTime, movieDate, movieId, seatsData);
    }
    /**
     * Sends request to delete a movie from database
     * @param movieId int for movieID of movie
     */
    @GetMapping("/deleteMovieSchedule")
    public void deleteMovieSchedule(@RequestParam(value = "movieId", defaultValue = "-1") int movieId){
        movieScheduleService.deleteMovieSchedule(movieId);
    }
    /**
     * Don't know that to comment
     */
    @DeleteMapping("/deleteMovieAllParameters")
    public void deleteMovieAllParameters(@RequestParam(value = "salonID", defaultValue = "-1")int salonID,
                                         @RequestParam(value = "movieTime", defaultValue = "-1")String movieTime,
                                         @RequestParam(value = "movieDate", defaultValue = "-1")String movieDate){
        this.movieScheduleService.deleteMovieScheduleAllParameters(salonID,movieTime,movieDate);

    }
    /**
     * Sends request to update movieSchedule in database
     * @param array update seatArrayOfMovie, updates seats in salon
     * @param salonID int salonID of salon
     * @param movieID int movieID of movie
     * @param time time when the movie starts
     * @param date date when the movie will play
     */
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
    /**
     * Sends request to download one movieSchedule from database
     * @param salonID int for salonID of salon
     * @param movieID int for movieID of movie
     * @param time time when the movie starts
     * @param date date when the movie is playing
     */
    @GetMapping("/downloadOneMovieSchedule")
    public String downloadOneMovieSchedule(
            @RequestParam("salonID") int salonID,
            @RequestParam(value = "movieID", defaultValue = "-1") int movieID,
            @RequestParam("time")String time,
            @RequestParam("date") String date){
        return movieScheduleService.downloadOneMovieSchedule(salonID, movieID, time,date);
    }
    /**
     * Sends request to download all movieSchedule from database
     * and display it in a list
     */
    @GetMapping("/downloadWholeMovieSchedule")
    public String downloadWholeMovieSchedule(){
        return movieScheduleService.downloadWholeMovieSchedule();
    }
}
