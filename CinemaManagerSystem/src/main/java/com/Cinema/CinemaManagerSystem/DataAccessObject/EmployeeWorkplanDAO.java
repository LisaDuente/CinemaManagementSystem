package com.Cinema.CinemaManagerSystem.DataAccessObject;

import com.Cinema.CinemaManagerSystem.Models.EmployeeWorkplan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * Data access object for employee workplan view in database
 */
@Repository
public class EmployeeWorkplanDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private String error;

    public EmployeeWorkplanDAO(){
        this.jdbcTemplate = new JdbcTemplate();
        this.error = "no";
    }

    /**
     * downloads the whole  employee workplan view
     * @return ArrayList<EmployeeWorkplan>
     */
    public ArrayList<EmployeeWorkplan> downloadEmployeeWorkplan(){
        String query = "SELECT * FROM employee_workplan";
        ArrayList<EmployeeWorkplan> workplan = new ArrayList<>();
        List<Map<String,Object>> rows = jdbcTemplate.queryForList(query);

        for(Map<String, Object> row : rows){
            EmployeeWorkplan employeeWorkplan = new EmployeeWorkplan(
                    String.valueOf(row.get("EmployeeName")),
                    String.valueOf(row.get("Workstation")),
                    String.valueOf(row.get("Task")),
                    String.valueOf(row.get("Shift")),
                    true);
            workplan.add(employeeWorkplan);
        }
        workplan.sort(Comparator.comparing(EmployeeWorkplan::getShift));

        return workplan;
    }

    //for testing purpose
    public String getError(){
        return error;
    }

    //for testing purpose
    public void setError(String error){
        this.error = error;
    }
}

