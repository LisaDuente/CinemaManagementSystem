package com.Cinema.CinemaManagerSystem.Controller;

import com.Cinema.CinemaManagerSystem.Service.SalonService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SalonController { // Toros

    @Autowired
    SalonService salonService;

    public SalonController(SalonService salonService){
        this.salonService = salonService;
    }

    // Just for reference
    //String salonID, int cinemaID, int salonRows, String salonSeats
    /**
     * Sends request to insert a salon to database
     * @param salonID int for salonID of salon
     * @param cinemaID what cinema the salon is registered in
     * @param salonRows how many rows the salon has
     * @param salonSeats how many seats the salon has
     */
    @PostMapping("/insertSalon")
    public void insertSalon(@RequestParam(value = "salonID", defaultValue = "-1") int salonID, @RequestParam(value = "cinemaID", defaultValue = "-1") int cinemaID, @RequestParam(value = "salonRows", defaultValue = "-1") int salonRows, @RequestParam(value = "salonSeats", defaultValue = "noSalonSeats") String salonSeats) {
        salonService.insertSalon(salonID, cinemaID, salonRows, salonSeats);
    }
    /**
     * Sends request to delete a salon from database by ID
     * @param salonID int for salonID of salon
     */
    @DeleteMapping("/deleteSalonByID")
    public void deleteSalon(@RequestParam(value = "salonID", defaultValue = "-1") int salonID){
        salonService.deleteSalonByID(salonID);
    }
    /**
     * Sends request to download one salon from database by salonID and cinemaID
     * @param salonID int for salonID of salon
     * @param cinemaId what cinema the salon is registered in
     */
    @GetMapping("/downloadOneSalon")
    public String downloadOneSalon(@RequestParam(value = "salonID", defaultValue = "-1") int salonID, @RequestParam(value = "cinemaID") int cinemaId){
        return salonService.downloadOneSalonByID(salonID, cinemaId);
    }
/*
    @GetMapping("/test")
    public String test(@RequestParam("id")int id){
        Gson gson = new Gson();
        return gson.toJson(salonService.test(id));
    }

 */


    // necessary ??
    //    @GetMapping("/downloadAllSalons")
    //    public String downloadAllSalons(){
    // }
}























