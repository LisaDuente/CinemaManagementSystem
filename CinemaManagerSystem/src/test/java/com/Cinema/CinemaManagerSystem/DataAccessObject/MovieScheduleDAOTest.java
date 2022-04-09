package com.Cinema.CinemaManagerSystem.DataAccessObject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.*;

// Toros
class MovieScheduleDAOTest {

    @Mock
    JdbcTemplate jdbcTemplateMock;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void insertMovieSchedule() {
        // setup
        // int salonId, String movieTime, String movieDate, int movieId, String array
        String query = "INSERT INTO movie_schedule VALUES(?,?,?,?,?);";
        int salonId = 1;
        String movieTime = "1h23m";
        String movieDate = "2022-02-06";
        int movieId = 1;
        String array = "arrayTest";
        Mockito.when(jdbcTemplateMock.update(query, salonId, movieTime, movieDate, movieId, array)).thenReturn(1);

        // action
        int i = jdbcTemplateMock.update(query, salonId, movieTime, movieDate, movieId, array);

        // result
        assertEquals(1, i);
        Mockito.verify(jdbcTemplateMock).update(query, salonId, movieTime, movieDate, movieId, array);
    }

    @Test
    void deleteMovieSchedule() {
    }

    @Test
    void testDeleteMovieSchedule() {
    }

    @Test
    void updateMovieScheduleById() {
    }

    @Test
    void downloadOneMovieSchedule() {
    }

    @Test
    void downloadWholeMovieSchedule() {
    }
}