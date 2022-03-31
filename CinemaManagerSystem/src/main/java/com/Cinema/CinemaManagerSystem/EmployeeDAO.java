package com.Cinema.CinemaManagerSystem;

import jdk.jshell.execution.JdiExecutionControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class EmployeeDAO {  // Toros
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private String error;

    public EmployeeDAO() {
        this.error = "no";
        this.jdbcTemplate = new JdbcTemplate();
    }

    // for reference:
    // int employeeID, String employeeName, String employeeTel, String employeeEmail
    public void insertNewEmployee(int employeeID, String employeeName, String employeeTel, String employeeEmail) {

        //should we insert null here to generate a new id with auto_increment in MySQL? Salon_ID is a varchar though.
        String query = "INSERT INTO employees VALUES (null, ?, ?, ?);";

        int result = jdbcTemplate.update(query, employeeName, employeeTel, employeeEmail);

        if (result > 0) {
            System.out.println(result + "employee added to database");
            this.error = "employee added to database";
        }
    }

    public void deleteEmployeeByID(int employeeID) {
        String query = "DELETE FROM employees WHERE employee_ID = ?;";
        int result = jdbcTemplate.update(query, employeeID);

        if (result > 0) {
            System.out.println(result + "employee deleted from database");
            this.error = "employee deleted from database";
        }
    }

    public Employee downloadOneEmployeeByName (String employeeName) {
        String query = "SELECT * FROM employees WHERE employee_name = ?;";
        Employee employee = this.jdbcTemplate.queryForObject(query, new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
                Employee innerEmployee = new Employee(
                        // for reference:
                        // int employeeID, String employeeName, String employeeTel, String employeeEmail
                        rs.getInt("employee_ID"),
                        rs.getString("employee_name"),
                        rs.getString("employee_tel"),
                        rs.getString("employee_email")
                );
                return innerEmployee;
            }
        }, employeeName);
        return employee;
    }

    public Employee downloadOneEmployeeByID(int employeeID) {
        String query = "SELECT * FROM employees WHERE employee_ID = ?;";
        Employee employee = this.jdbcTemplate.queryForObject(query, new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
                Employee innerEmployee = new Employee(
                        rs.getInt("employee_ID"),
                        rs.getString("employee_name"),
                        rs.getString("employee_tel"),
                        rs.getString("employee_email")
                );
                return innerEmployee;
            }
        }, employeeID);
        return employee;
    }

    // necessary ??
    //public ArrayList<Employee> downloadAllEmployees(){
    //
    //}

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
