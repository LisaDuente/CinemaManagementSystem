package com.Cinema.CinemaManagerSystem.Controller;

import com.Cinema.CinemaManagerSystem.Service.EmployeeScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeScheduleController {
    @Autowired
    EmployeeScheduleService employeeScheduleService;

    public EmployeeScheduleController(EmployeeScheduleService employeeScheduleService){
        this.employeeScheduleService = employeeScheduleService;
    }
    /**
     * Sends request to insert a new employeeSchedule to database
     * @param employeeId int for employeeID of employee we want to register in employeeSchedule
     * @param taskId task for employee
     * @param workstationId workstation for employee
     * @param shift what time the shift start and ends
     */
    @PostMapping("/insertEmployeeSchedule")
    public void insertEmployeeSchedule(@RequestParam(value = "employeeId", defaultValue = "-1") int employeeId,
                                       @RequestParam(value = "taskId", defaultValue = "-1") int taskId,
                                       @RequestParam(value = "workstationId", defaultValue = "-1") int workstationId,
                                       @RequestParam(value = "shift", defaultValue = "noShift") String shift){
        employeeScheduleService.insertNewEmployeeSchedule(employeeId, taskId, workstationId, shift);
    }

    /**
     * Sends request to delete an employee from employeeSchedule from database
     * @param employeeId int for employeeID of employee we want to delete from employeeSchedule
     */
    @PostMapping("/deleteEmployeeScheduleById")
    public void deleteEmployeeSchedule(@RequestParam(value = "employeeId", defaultValue = "-1") int employeeId){
        employeeScheduleService.deleteEmployeeSchedule(employeeId);
    }

}
