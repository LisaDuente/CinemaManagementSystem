package com.Cinema.CinemaManagerSystem.Controller;

import com.Cinema.CinemaManagerSystem.Service.MovieScheduleViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
