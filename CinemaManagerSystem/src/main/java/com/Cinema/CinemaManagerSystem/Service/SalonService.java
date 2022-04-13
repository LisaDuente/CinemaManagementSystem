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

    /**
     * Sends information to DAO class for inserting a new salon
     *
     * @param salonID
     * @param cinemaID
     * @param salonRows
     * @param salonSeats
     */
    public void insertSalon(int salonID, int cinemaID, int salonRows, String salonSeats) {
        salonDAO.insertNewSalon(salonID, cinemaID, salonRows, salonSeats);
    }

    /**
     * Sends information to DAO class for deleting a salon, using ID
     *
     * @param idDelete
     */
    public void deleteSalonByID(int idDelete) {
        salonDAO.deleteSalonByID(idDelete);
    }

    /**
     * @param salonID
     * @param cinemaId
     * @return gson String with information regarding one salon, using salonID and cinemaID, sends it to DAO class.
     */
    public String downloadOneSalonByID(int salonID, int cinemaId) {
        Gson gson = new Gson();
        salon = salonDAO.downloadOneSalonByID(salonID, cinemaId);
        return gson.toJson(salon);
    }
}