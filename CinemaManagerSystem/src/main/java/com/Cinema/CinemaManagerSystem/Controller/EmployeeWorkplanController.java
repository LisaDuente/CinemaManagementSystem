package com.Cinema.CinemaManagerSystem.Controller;

import com.Cinema.CinemaManagerSystem.Service.EmployeeWorkplanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeWorkplanController {

    @Autowired
    EmployeeWorkplanService employeeWorkplanService;

    public EmployeeWorkplanController(EmployeeWorkplanService employeeWorkplanService){
        this.employeeWorkplanService = employeeWorkplanService;
    }

    @GetMapping("/downloadEmployeeWorkplan")
    public String downloadAllMovies(){
        return employeeWorkplanService.downloadEmployeeWorkplan();
    }

}
