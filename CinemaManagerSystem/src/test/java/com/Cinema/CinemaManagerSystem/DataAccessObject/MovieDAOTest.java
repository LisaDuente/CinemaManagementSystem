package com.Cinema.CinemaManagerSystem.DataAccessObject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

// Toros
class MovieDAOTest {

    @Mock
    JdbcTemplate jdbcTemplateMock;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void insertNewMovie() {
        //setup
        String query = "INSERT INTO movie VALUES(null,?,?,?,?,?,?);";
        // (String name, String genre, String duration, String description, String shortDescription, String path)
        String name = "test01";
        String genre = "test02";
        String duration = "test03";
        String description = "test04";
        String shortDescription = "test05";
        String path = "test06";
        Mockito.when(jdbcTemplateMock.update(query, name, genre, duration, description, shortDescription, path)).thenReturn(1);

        // action
        int i = jdbcTemplateMock.update(query, name, genre, duration, description, shortDescription, path);

        // result
        assertEquals(1, i);
        Mockito.verify(jdbcTemplateMock).update(query, name, genre, duration, description, shortDescription, path);
    }



    @Test
    void deleteMovie() {
    }

    @Test
    void downloadOneMovie() {
    }

    @Test
    void downloadAllMovies() {
    }

    @Test
    void newlyAddedMovie() {
    }

    @Test
    void getError() {
    }

    @Test
    void setError() {
    }
}