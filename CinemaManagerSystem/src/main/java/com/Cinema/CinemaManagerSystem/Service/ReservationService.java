package com.Cinema.CinemaManagerSystem.Service;

import com.Cinema.CinemaManagerSystem.DataAccessObject.ReservationDAO;
import com.Cinema.CinemaManagerSystem.Models.Reservation;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ReservationService {
    @Autowired
    ReservationDAO dao;

    /**
     * sends information to ReservationDAO class regarding making a movie/salon reservation
     *
     * @param seats
     * @param salonID
     * @param row
     * @param movieID
     * @param time
     * @param date
     */
    public void makeReservation(String seats, int salonID, String row, int movieID, String time, String date) {
        dao.makeReservation(seats, salonID, row, movieID, time, date);
    }

    /**
     * @param ID
     * @return gson String of a reservation from an ID, sends it to DAO class.
     */
    public String getReservation(int ID) {
        Gson gson = new Gson();
        ArrayList<Reservation> res = dao.getReservation(ID);
        String resString = gson.toJson(res);
        return resString;
    }

    /**
     * @return an int representing the ID of the max ID for reservation, sends it to DAO class.
     */
    public int getLatestID() {
        return dao.getLatestReservationID();
    }
}
