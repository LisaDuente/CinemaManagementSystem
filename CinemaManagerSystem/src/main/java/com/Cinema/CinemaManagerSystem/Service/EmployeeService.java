package com.Cinema.CinemaManagerSystem.Service;

import com.Cinema.CinemaManagerSystem.Models.Employee;
import com.Cinema.CinemaManagerSystem.DataAccessObject.EmployeeDAO;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EmployeeService { // Toros
    @Autowired
    EmployeeDAO employeeDAO;
    Employee employee;
    ArrayList<Employee> employees;

    // for reference:
    // int employeeID, String employeeName, String employeeTel, String employeeEmail
    public void insertNewEmployee(int employeeID, String employeeName, String employeeTel, String employeeEmail) {
        employeeDAO.insertNewEmployee(employeeID, employeeName, employeeTel, employeeEmail);
    }

    public void deleteEmployeeByID(int idDelete) {
        employeeDAO.deleteEmployeeByID(idDelete);
    }

    public String downloadOneEmployeeByID(int employeeID) {
        Gson gson = new Gson();
        employee = employeeDAO.downloadOneEmployeeByID(employeeID);
        String employeeString = gson.toJson(employee);
        return employeeString;
    }

    public String downloadOneEmployeeByName(String employeeName) {
        Gson gson = new Gson();
        employee = employeeDAO.downloadOneEmployeeByName(employeeName);
        String employeeString = gson.toJson(employee);
        return employeeString;
    }

    public String downloadAllEmployees(){
        employees = employeeDAO.downloadAllEmployees();
        Gson gson = new Gson();
        String employeeListString = gson.toJson(employees);
        return employeeListString;
    }

    public void updateEmployee(int id,String name, String tel, String mail){
        employeeDAO.updateEmployee(id,name, tel, mail);
    }

    // necessary ??
    //public String downloadAllSalons(){
    //
    //}
}
