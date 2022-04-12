package com.Cinema.CinemaManagerSystem.DataAccessObject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.*;

// Toros
class EmployeeWorkplanDAOTest {

    @Mock
    JdbcTemplate jdbcTemplateMock;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void downloadEmployeeWorkplan() {
    }

    @Test
    void getError() {
    }

    @Test
    void setError() {
    }
}