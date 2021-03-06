package com.Cinema.CinemaManagerSystem.DataAccessObject;

import com.Cinema.CinemaManagerSystem.Models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Data access object for employee table
 */
@Repository
public class EmployeeDAO {  // Toros
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private String error;

    public EmployeeDAO() {
        this.error = "no";
        this.jdbcTemplate = new JdbcTemplate();
    }


    /**
     * inserts new employee in database
     * @param employeeID int
     * @param employeeName String
     * @param employeeTel String
     * @param employeeEmail String
     */
    public void insertNewEmployee(int employeeID, String employeeName, String employeeTel, String employeeEmail) {

        //should we insert null here to generate a new id with auto_increment in MySQL? Salon_ID is a varchar though.
        String query = "INSERT INTO employees VALUES (null, ?, ?, ?);";

        int result = jdbcTemplate.update(query, employeeName, employeeTel, employeeEmail);

        if (result > 0) {
            System.out.println(result + "employee added to database");
            this.error = "employee added to database";
        }
    }

    /**
     * deletes an employee from database by ID
     * @param employeeID int
     */
    public void deleteEmployeeByID(int employeeID) {
        String query = "DELETE FROM employees WHERE employee_ID = ?;";
        int result = jdbcTemplate.update(query, employeeID);

        if (result > 0) {
            System.out.println(result + "employee deleted from database");
            this.error = "employee deleted from database";
        }
    }

    /**
     * downloads one employee by name
     * @param employeeName String
     * @return Employee class
     */
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

    /**
     * downloads one employee by ID
     * @param employeeID int
     * @return
     */
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

    /**
     * downloads the whole employee table
     * @return ArrayList<Employee>
     */
    public ArrayList<Employee> downloadAllEmployees(){
        String query = "SELECT * FROM employees";
        ArrayList<Employee> employees = new ArrayList<>();
        List<Map<String,Object>> rows = jdbcTemplate.queryForList(query);

        for(Map<String, Object> row : rows){
            Employee employee = new Employee(
                    (int) (long) row.get("employee_id"),
                    String.valueOf(row.get("employee_name")),
                    String.valueOf(row.get("employee_tel")),
                    String.valueOf(row.get("employee_email"))
                    );
            employees.add(employee);
        }

        return employees;
    }

    /**
     * updates a specified employee in the database.
     * @param id int
     * @param name String
     * @param tel String
     * @param mail String
     */
    public void updateEmployee(int id,String name, String tel, String mail){

        String query = "UPDATE employees SET employee_name = ?, employee_tel = ?, employee_email = ? WHERE employee_ID = ?;";

        int result = jdbcTemplate.update(query, name, tel, mail, id);

        if(result > 0){
            System.out.println(result + " employee updated in database");
            this.error = "employee updated in database";
        }
    }
    //for testing purpose
    public String getError() {
        return error;
    }
    //for testing purpose
    public void setError(String error) {
        this.error = error;
    }
}
