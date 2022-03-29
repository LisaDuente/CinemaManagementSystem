package com.Cinema.CinemaManagerSystem;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SalonService { // Toros
    @Autowired
    SalonDAO salonDAO;
    Salon salon;
    ArrayList<Salon> salons;

    public void insertSalon(String salonID, int cinemaID, int salonRows, String salonSeats) {
        salonDAO.insertNewSalon(salonID, cinemaID, salonRows, salonSeats);
    }

    public void deleteSalon(String idDelete) {
        salonDAO.deleteSalon(idDelete);
    }

    public String downloadOneSalon(String salonID) {
        Gson gson = new Gson();
        salon = salonDAO.downloadOneSalon(salonID);
        String salonString = gson.toJson(salon);
        return salonString;
    }

    // necessary ??
    //public String downloadAllSalons(){
    //
    //}
}