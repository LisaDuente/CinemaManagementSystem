package com.Cinema.CinemaManagerSystem.Service;

import com.Cinema.CinemaManagerSystem.Models.Salon;
import com.Cinema.CinemaManagerSystem.DataAccessObject.SalonDAO;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SalonService { // Toros ||ERKAN
    @Autowired
    SalonDAO salonDAO;
    Salon salon;
    ArrayList<Salon> salons;

    public void insertSalon(int salonID, int cinemaID, int salonRows, String salonSeats) {
        salonDAO.insertNewSalon(salonID, cinemaID, salonRows, salonSeats);
    }

    public void deleteSalonByID(int idDelete) {
        salonDAO.deleteSalonByID(idDelete);
    }

    public String downloadOneSalonByID(int salonID, int cinemaId) {
        Gson gson = new Gson();
        salon = salonDAO.downloadOneSalonByID(salonID, cinemaId);
        return gson.toJson(salon);
    }
}