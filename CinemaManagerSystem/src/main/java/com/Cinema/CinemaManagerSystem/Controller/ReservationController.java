package com.Cinema.CinemaManagerSystem.Controller;

import com.Cinema.CinemaManagerSystem.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservationController {

    @Autowired
    ReservationService service;

    @PostMapping("/makeReservation")
    public void makeReservation(@RequestParam(value = "seats", defaultValue = "0,0")String seats,
                                @RequestParam(value = "salonID", defaultValue = "1") int salonID,
                                @RequestParam(value = "row", defaultValue = "1") String row,
                                @RequestParam(value = "movieID", defaultValue = "1") int movieID,
                                @RequestParam(value = "time", defaultValue = "00:00")String time,
                                @RequestParam(value = "date", defaultValue = "2022-01-01") String date){
        service.makeReservation(seats,salonID,row,movieID,time,date);
    }

    @GetMapping("/getReservation")
    public String getReservation(@RequestParam(value = "ID", defaultValue = "1") int ID){
        return service.getReservation(ID);
    }

    @GetMapping("/getLatestReservationID")
    public int getLatestID(){
        return service.getLatestID();
    }
}
