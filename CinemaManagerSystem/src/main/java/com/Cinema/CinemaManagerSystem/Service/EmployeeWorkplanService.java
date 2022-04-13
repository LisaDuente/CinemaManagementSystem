package com.Cinema.CinemaManagerSystem.Service;

import com.Cinema.CinemaManagerSystem.DataAccessObject.EmployeeWorkplanDAO;
import com.Cinema.CinemaManagerSystem.Models.EmployeeWorkplan;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EmployeeWorkplanService {

    @Autowired
    EmployeeWorkplanDAO dao;
    ArrayList<EmployeeWorkplan> employeeWorkplan;

    /**
     * @return Employee workplan from a gson String, sends it to DAO class.
     */
    public String downloadEmployeeWorkplan() {
        employeeWorkplan = dao.downloadEmployeeWorkplan();
        Gson gson = new Gson();
        String employeeWorkplanListString = gson.toJson(employeeWorkplan);
        return employeeWorkplanListString;
    }
}
