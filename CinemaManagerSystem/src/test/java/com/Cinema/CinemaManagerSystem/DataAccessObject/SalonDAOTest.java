package com.Cinema.CinemaManagerSystem.DataAccessObject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.*;

// Toros
class SalonDAOTest {

    @Mock
    JdbcTemplate jdbcTemplateMock;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    //insertNewSalon(int salonID, int cinemaID, int salonRows, String salonSeats)
    void insertNewSalon() {
        // setup
        String query = "INSERT INTO salon VALUES(?, ?);";
        int salonID = 9;
        int cinemaID = 7;
        // int salonRows = 6;
        // String salonSeats = "test01";
        Mockito.when(jdbcTemplateMock.update(query, salonID, cinemaID)).thenReturn(1);

        // action
        int i = jdbcTemplateMock.update(query, salonID, cinemaID);

        // result
        assertEquals(1, i);
        Mockito.verify(jdbcTemplateMock).update(query, salonID, cinemaID);
    }

    @Test
    void deleteSalonByID() {
    }

    @Test
    void downloadOneSalonByID() {
    }

    @Test
    void getError() {
    }

    @Test
    void setError() {
    }
}