package com.Cinema.CinemaManagerSystem.DataAccessObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Data Access Object for employeeSchedule in the database
 */
@Repository
public class EmployeeScheduleDAO {
    @Autowired
    private JdbcTemplate jdcbTemplate;
    private String error;

    public EmployeeScheduleDAO(){
        this.error = "no";
        this.jdcbTemplate = new JdbcTemplate();
    }

    /**
     * insert a new row in employeeSchedule
     * @param employeeId int
     * @param taskId int
     * @param workstationId int
     * @param shift String
     */
    public void insertNewEmployeeSchedule(int employeeId, int taskId, int workstationId, String shift){

        String query = "INSERT INTO employee_schedule VALUES(?,?,?,?);";

        int result = jdcbTemplate.update(query, employeeId, taskId, workstationId, shift);

        if(result > 0){
            System.out.println(result + " employee_schedule added to database");
            this.error = "employee_schedule added to database";
        }
    }

    /**
     * deletes a row from employeeSchedule by employee ID
     * @param employeeId int
     */
    public void deleteEmployeeSchedule(int employeeId){
        String query = "DELETE FROM employee_schedule WHERE employee_ID = ?";
        int result = jdcbTemplate.update(query, employeeId);
    }

}
