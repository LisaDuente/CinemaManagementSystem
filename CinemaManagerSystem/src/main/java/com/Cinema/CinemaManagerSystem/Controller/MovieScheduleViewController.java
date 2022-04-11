package com.Cinema.CinemaManagerSystem.Controller;

import com.Cinema.CinemaManagerSystem.Service.MovieScheduleViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieScheduleViewController {

    @Autowired
    MovieScheduleViewService service;

    public MovieScheduleViewController(){
        this.service = new MovieScheduleViewService();
    }

    @GetMapping("/downloadWholeMovieScheduleView")
        public String downloadWholeView(){
            return service.downloadWholeView();
        }

    @GetMapping("/getAllInfoOneMovie")
    public String downloadAllInfoOneMovie(@RequestParam (value = "movieName", defaultValue = "none")String movieName){
        return service.downloadAllInfoOneMovie(movieName);
    }
}
