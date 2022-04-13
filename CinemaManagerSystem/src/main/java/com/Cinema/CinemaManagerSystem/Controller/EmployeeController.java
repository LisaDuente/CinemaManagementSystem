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
    /**
     * Method parameters that is bound to web request parameter.
     * Sends request to insert new employee to database
     * @param employeeID int for employee_ID of Employee
     * @param employeeName name of Employee
     * @param employeeTel tel of Employee
     * @param employeeEmail email of Employee
     */
    @PostMapping("/insertNewEmployee")
    public void insertNewEmployee(@RequestParam(value = "employee_ID", defaultValue = "-1") int employeeID,
                                  @RequestParam(value = "employee_name", defaultValue = "noEmployeeName") String employeeName,
                                  @RequestParam(value = "employee_tel", defaultValue = "noEmployeeTel") String employeeTel,
                                  @RequestParam(value = "employee_email", defaultValue = "noEmployeeEmail") String employeeEmail) {
        employeeService.insertNewEmployee(employeeID, employeeName, employeeTel, employeeEmail);
    }
    /**
     * Method parameters that is bound to web request parameter.
     * Sends request to delete new employee by ID from database
     * @param employeeID int for employee_ID of Employee
     */
    @DeleteMapping ("/deleteEmployeeByID")
    public void deleteEmployeeByID(@RequestParam(value = "employee_ID", defaultValue = "-1") int employeeID) {
        employeeService.deleteEmployeeByID(employeeID);
    }
    /**
     * Method parameters that is bound to web request parameter.
     * Sends request to delete new employee by ID from database
     * @param employeeName int for employee_ID of Employee
     */
    @GetMapping("/downloadOneEmployeeByName")
    public String downloadOneEmployeeByName(@RequestParam(value = "employeeName", defaultValue = "-1") String employeeName) {
        return employeeService.downloadOneEmployeeByName(employeeName);
    }
    /**
     * Method parameters that is bound to web request parameter.
     * Sends request to donwload one employee by ID
     * @param employeeID int for employee_ID of Employee
     */
    @GetMapping("/downloadOneEmployeeByID")
    public String downloadOneEmployeeByID(@RequestParam(value = "employee_ID", defaultValue = "-1")int employeeID) {
        return employeeService.downloadOneEmployeeByID(employeeID);
    }
    /**
     * Method parameters that is bound to web request parameter.
     * Sends request to download all employees from database
     */
    @GetMapping("/downloadAllEmployees")
    public String downloadAllEmployees(){
        return employeeService.downloadAllEmployees();
    }

    /**
     * Method parameters that is bound to web request parameter.
     * Sends request to update an employee, specify what ID you want to update
     * @param id int for employee_ID of Employee
     * @param name name of employee
     * @param tel of employee
     * @param mail of employee
     */
    @PostMapping("/updateEmployee")
    public void updateMovie(@RequestParam(value = "id", defaultValue = "0")int id,
                            @RequestParam(value = "name", defaultValue = "noName")String name,
                            @RequestParam(value = "tel", defaultValue = "noTel")String tel,
                            @RequestParam(value = "mail", defaultValue = "noMail")String mail
                            ){
        employeeService.updateEmployee(id, name, tel, mail);
    }
}
