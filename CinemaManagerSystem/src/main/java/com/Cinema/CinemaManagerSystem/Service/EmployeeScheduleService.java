package com.Cinema.CinemaManagerSystem.Service;

import com.Cinema.CinemaManagerSystem.DataAccessObject.EmployeeScheduleDAO;
import com.Cinema.CinemaManagerSystem.Models.EmployeeSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeScheduleService {

    @Autowired
    EmployeeScheduleDAO employeeScheduleDAO;
    EmployeeSchedule employeeSchedule;

    /**
     * Sends information to DAO class for inserting new Employee Schedule.
     *
     * @param employeeId
     * @param taskId
     * @param workstationId
     * @param shift
     */
    public void insertNewEmployeeSchedule(int employeeId, int taskId, int workstationId, String shift) {
        employeeScheduleDAO.insertNewEmployeeSchedule(employeeId, taskId, workstationId, shift);
    }

    /**
     * Sends information to DAO class for deleting Employee schedule, based on employee ID.
     *
     * @param employeeId
     */
    public void deleteEmployeeSchedule(int employeeId) {
        employeeScheduleDAO.deleteEmployeeSchedule(employeeId);
    }
}
