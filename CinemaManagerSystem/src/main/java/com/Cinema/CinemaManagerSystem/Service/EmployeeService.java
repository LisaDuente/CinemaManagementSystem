package com.Cinema.CinemaManagerSystem.Service;

import com.Cinema.CinemaManagerSystem.Models.Employee;
import com.Cinema.CinemaManagerSystem.DataAccessObject.EmployeeDAO;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

// Toros
@Service
public class EmployeeService {

    @Autowired
    EmployeeDAO employeeDAO;
    Employee employee;
    ArrayList<Employee> employees;

    /**
     * Sends information to DAO class for inserting one new Employee
     *
     * @param employeeID
     * @param employeeName
     * @param employeeTel
     * @param employeeEmail
     */
    public void insertNewEmployee(int employeeID, String employeeName, String employeeTel, String employeeEmail) {
        employeeDAO.insertNewEmployee(employeeID, employeeName, employeeTel, employeeEmail);
    }

    /**
     * Sends information to DAO class for deleting one Employee from database, based on ID.
     *
     * @param idDelete
     */
    public void deleteEmployeeByID(int idDelete) {
        employeeDAO.deleteEmployeeByID(idDelete);
    }

    /**
     * @param employeeID
     * @return gson String consisting of one Employee info, based on which Employee ID you input, Sends it to DAO class.
     */
    public String downloadOneEmployeeByID(int employeeID) {
        Gson gson = new Gson();
        employee = employeeDAO.downloadOneEmployeeByID(employeeID);
        String employeeString = gson.toJson(employee);
        return employeeString;
    }

    /**
     * @param employeeName
     * @return gson String consisting of one Employee info, based on which Employee name you input, sends it to DAO class.
     */
    public String downloadOneEmployeeByName(String employeeName) {
        Gson gson = new Gson();
        employee = employeeDAO.downloadOneEmployeeByName(employeeName);
        String employeeString = gson.toJson(employee);
        return employeeString;
    }

    /**
     * @return gson String consisting of ALL Employee info, based on which Employee name you input, sends information to DAO class.
     */
    public String downloadAllEmployees() {
        employees = employeeDAO.downloadAllEmployees();
        Gson gson = new Gson();
        String employeeListString = gson.toJson(employees);
        return employeeListString;
    }

    /**
     * Sends information to DAO class for updating one Employee info
     *
     * @param id
     * @param name
     * @param tel
     * @param mail
     */
    public void updateEmployee(int id, String name, String tel, String mail) {
        employeeDAO.updateEmployee(id, name, tel, mail);
    }
}
