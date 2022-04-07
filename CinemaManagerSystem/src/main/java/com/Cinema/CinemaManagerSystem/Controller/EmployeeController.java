package com.Cinema.CinemaManagerSystem.Controller;

import com.Cinema.CinemaManagerSystem.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {  // Toros

    @Autowired
    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // for reference:
    // int employeeID, String employeeName, String employeeTel, String employeeEmail

    // methods:
    // insertNewEmployee
    // deleteEmployeeByID
    // downloadOneEmployeeByName
    // downloadOneEmployeeByID

    @PostMapping("/insertNewEmployee")
    public void insertNewEmployee(@RequestParam(value = "employee_ID", defaultValue = "-1") int employeeID, @RequestParam(value = "employee_name", defaultValue = "noEmployeeName") String employeeName, @RequestParam(value = "employee_tel", defaultValue = "noEmployeeTel") String employeeTel, @RequestParam(value = "employee_email", defaultValue = "noEmployeeEmail") String employeeEmail) {
        employeeService.insertNewEmployee(employeeID, employeeName, employeeTel, employeeEmail);
    }

    @DeleteMapping ("/deleteEmployeeByID")
    public void deleteEmployeeByID(@RequestParam(value = "employee_ID", defaultValue = "-1") int employeeID) {
        employeeService.deleteEmployeeByID(employeeID);
    }

    @GetMapping("/downloadOneEmployeeByName")
    public String downloadOneEmployeeByName(@RequestParam(value = "employeeName", defaultValue = "-1") String employeeName) {
        return employeeService.downloadOneEmployeeByName(employeeName);
    }

    @GetMapping("/downloadOneEmployeeByID")
    public String downloadOneEmployeeByID(@RequestParam(value = "employee_ID", defaultValue = "-1") int employeeID, @RequestParam(value = "employee_name", defaultValue = "noEmployeeName") String employeeName, @RequestParam(value = "employee_tel", defaultValue = "noEmployeeTel") String employeeTel, @RequestParam(value = "employee_email", defaultValue = "noEmployeeEmail") String employeeEmail) {
        return employeeService.downloadOneEmployeeByID(employeeID);
    }

    @GetMapping("/downloadAllEmployees")
    public String downloadAllEmployees(){
        return employeeService.downloadAllEmployees();
    }

    @PostMapping("/updateEmployee")
    public void updateMovie(@RequestParam(value = "id", defaultValue = "0")int id,
                            @RequestParam(value = "name", defaultValue = "noName")String name,
                            @RequestParam(value = "tel", defaultValue = "noTel")String tel,
                            @RequestParam(value = "mail", defaultValue = "noMail")String mail
                            ){
        employeeService.updateEmployee(id, name, tel, mail);
    }




























}
