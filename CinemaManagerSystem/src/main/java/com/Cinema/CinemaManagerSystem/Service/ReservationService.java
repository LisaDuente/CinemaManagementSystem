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

    public void makeReservation(String seats, int salonID, String row, int movieID, String time, String date){
        dao.makeReservation(seats,salonID,row,movieID,time,date);
    }

    public String getReservation(int ID){
        Gson gson = new Gson();
        ArrayList<Reservation> res = dao.getReservation(ID);
        String resString = gson.toJson(res);
        return resString;
    }

    public int getLatestID(){
        return dao.getLatestReservationID();
    }
}
