package com.Cinema.CinemaManagerSystem.DataAccessObject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.*;

// Toros
class EmployeeScheduleDAOTest {

    @Mock
    JdbcTemplate jdbcTemplateMock;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void insertNewEmployeeSchedule() {
        // setup
        String query = "INSERT INTO employee_schedule VALUES(?,?,?,?);";
        int employeeId = 1;
        int taskId = 1;
        int workstationId = 1;
        String shift = "dancing";
        // insertNewEmployeeSchedule(int employeeId, int taskId, int workstationId, String shift){
        Mockito.when(jdbcTemplateMock.update(query, employeeId, taskId, workstationId, shift)).thenReturn(1);

        // action
        int i = jdbcTemplateMock.update(query, employeeId, taskId, workstationId, shift);

        // result
        assertEquals(1, i);
        Mockito.verify(jdbcTemplateMock).update(query, employeeId, taskId, workstationId, shift);
    }

    @Test
    void deleteEmployeeSchedule() {
    }
}