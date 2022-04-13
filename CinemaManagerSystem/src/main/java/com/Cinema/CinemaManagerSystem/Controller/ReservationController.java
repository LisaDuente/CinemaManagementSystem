package com.Cinema.CinemaManagerSystem.Controller;

import com.Cinema.CinemaManagerSystem.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservationController {

    @Autowired
    ReservationService service;

    @PostMapping("/makeReservation")
    public void makeReservation(String seats, int salonID, String row, int movieID, String time, String date){
        service.makeReservation(seats,salonID,row,movieID,time,date);
    }

    @GetMapping("/getReservation")
    public String getReservation(int ID){
        return service.getReservation(ID);
    }

    @GetMapping("/getLatestReservationID")
    public int getLatestID(){
        return service.getLatestID();
    }
}
