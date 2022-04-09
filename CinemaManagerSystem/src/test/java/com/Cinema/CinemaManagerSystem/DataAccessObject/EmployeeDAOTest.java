package com.Cinema.CinemaManagerSystem.DataAccessObject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.*;

// Toros
class EmployeeDAOTest {

    @Mock
    JdbcTemplate jdbcTemplateMock;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void insertNewEmployee() {
        // setup
        String query = "INSERT INTO employees VALUES (null, ?, ?, ?);";
        // insertNewEmployee(int employeeID, String employeeName, String employeeTel, String employeeEmail) {
        int employeeID = 1;
        String employeeName = "edward";
        String employeeTel = "secret";
        String employeeEmail = "test@test.test";
        Mockito.when(jdbcTemplateMock.update(query, employeeID, employeeName, employeeTel, employeeEmail)).thenReturn(1);

        // action
        int i = jdbcTemplateMock.update(query, employeeID, employeeName, employeeTel, employeeEmail);

        // result
        assertEquals(1, i);
        Mockito.verify(jdbcTemplateMock).update(query, employeeID, employeeName, employeeTel, employeeEmail);
    }

    @Test
    void deleteEmployeeByID() {
    }

    @Test
    void downloadOneEmployeeByName() {
    }

    @Test
    void downloadOneEmployeeByID() {
    }

    @Test
    void downloadAllEmployees() {
    }

    @Test
    void updateEmployee() {
    }

    @Test
    void getError() {
    }

    @Test
    void setError() {
    }
}