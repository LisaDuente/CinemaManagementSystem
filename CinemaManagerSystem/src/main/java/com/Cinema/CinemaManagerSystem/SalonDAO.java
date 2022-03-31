package com.Cinema.CinemaManagerSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class SalonDAO { // Toros
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private String error;

    public SalonDAO() {
        this.error = "no";
        this.jdbcTemplate = new JdbcTemplate();
    }

    /**
     * method to insert a new salon into the database
     *
     * @param salonID    salon_ID in salon in cinema database
     * @param cinemaID   cinema_ID in salon in cinema database
     * @param salonRows  salon_row in salon_info in cinema database
     * @param salonSeats seat in salon_info in cinema database
     */
    public void insertNewSalon(int salonID, int cinemaID, int salonRows, String salonSeats) {

        //should we insert null here to generate a new id with auto_increment in MySQL? Salon_ID is a varchar though.
        String query = "INSERT INTO salon VALUES(?, ?, ?, ?);";

        int result = jdbcTemplate.update(query, salonID, cinemaID, salonRows, salonSeats);

        if (result > 0) {
            System.out.println(result + " salon added to database");
            this.error = "movie added to database";
        }
    }

    /**
     * method to delete a salon from database
     *
     * @param salonID salon_ID in salon in cinema database
     */
    public void deleteSalonByID(int salonID) {
        String query = "DELETE FROM salon WHERE salon_ID = ?;";
        int result = jdbcTemplate.update(query, salonID);

        if (result > 0) {
            System.out.println(result + "salon deleted from database");
            this.error = "employee deleted from database";
        }
    }

    /**
     * downloads one salon from the database
     *
     * @param salonID salon_ID in salon in cinema database
     * @return salon object
     */
    public Salon downloadOneSalonByID(int salonID) {
        String query = "SELECT * FROM salon WHERE salon_ID = ?;";
        Salon salon = this.jdbcTemplate.queryForObject(query, new RowMapper<Salon>() {
            @Override
            public Salon mapRow(ResultSet rs, int rowNum) throws SQLException {
                Salon innerSalon = new Salon(
                        //String salonID, int cinemaID, int salonRows, String salonSeats
                        //* @param salonID salon_ID in salon in cinema database
                        //* @param cinemaID cinema_ID in salon in cinema database
                        //* @param salonRows salon_row in salon_info in cinema database
                        //* @param salonSeats seat in salon_info in cinema database
                        rs.getInt("salon_ID"),
                        rs.getInt("cinema_ID"),
                        rs.getInt("salon_row"),
                        rs.getString("seat")
                );
                return innerSalon;
            }
        }, salonID);
        return salon;
    }

    // necessary ??
    //public ArrayList<Salon> downloadAllSalons(){
    //
    //}

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}