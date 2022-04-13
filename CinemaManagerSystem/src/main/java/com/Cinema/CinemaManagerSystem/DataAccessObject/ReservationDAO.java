package com.Cinema.CinemaManagerSystem.DataAccessObject;

import com.Cinema.CinemaManagerSystem.Models.Movie;
import com.Cinema.CinemaManagerSystem.Models.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Repository
public class ReservationDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ReservationDAO(){
        this.jdbcTemplate = new JdbcTemplate();
    }

    public void makeReservation(String seats, int salonID, String row, int movieID, String time, String date){
        String query = "{CALL MakeMultipleReservations(?,?,?,?,?,?)}";
        List<SqlParameter> parameters = Arrays.asList(new SqlParameter(Types.NVARCHAR), new SqlParameter(Types.INTEGER),
                new SqlParameter(Types.NVARCHAR),new SqlParameter(Types.INTEGER),new SqlParameter(Types.NVARCHAR),
                new SqlParameter(Types.NVARCHAR));

        jdbcTemplate.call((CallableStatementCreator) con -> {
            CallableStatement cs = con.prepareCall(query);
            cs.setString(1,seats);
            cs.setInt(2,salonID);
            cs.setString(3, row);
            cs.setInt(4,movieID);
            cs.setString(5,time);
            cs.setString(6,date);
            return cs;
        },parameters);
    }

    public ArrayList<Reservation> getReservation(int ID){
        ArrayList<Reservation> reservations = new ArrayList<>();
        String query = "SELECT reservations.reservation_ID, customer_ID,seat,salon_ID,`row`,movie_ID,movie_time,movie_date FROM reservations INNER JOIN reservation_details ON reservations.reservation_ID = reservation_details.reservation_id WHERE reservations.reservation_ID = ?;";
        List<Map<String,Object>> rows = jdbcTemplate.queryForList(query,ID);

        for(Map<String,Object>  row: rows){
            Reservation innerRes = new Reservation(
                    (int)(long)row.get("customer_ID"),
                    (int)(long)row.get("reservation_ID"),
                    (int)row.get("salon_ID"),
                    (int)(long)row.get("movie_ID"),
                    String.valueOf(row.get("row")),
                    String.valueOf(row.get("seat")),
                    String.valueOf(row.get("movie_time")),
                    String.valueOf(row.get("movie_date"))
            );
            reservations.add(innerRes);
        }
        return reservations;
    }

    public int getLatestReservationID(){
        String query = "SELECT MAX(reservation_ID) AS ID from reservations";
        List<Map<String,Object>> rows = jdbcTemplate.queryForList(query);
        return (int)(long)rows.get(0).get("ID");
    }
}
