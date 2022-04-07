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

    @PostMapping("/insertEmployeeSchedule")
    public void insertEmployeeSchedule(@RequestParam(value = "employeeId", defaultValue = "-1") int employeeId,
                                       @RequestParam(value = "taskId", defaultValue = "-1") int taskId,
                                       @RequestParam(value = "workstationId", defaultValue = "-1") int workstationId,
                                       @RequestParam(value = "shift", defaultValue = "noShift") String shift){
        employeeScheduleService.insertNewEmployeeSchedule(employeeId, taskId, workstationId, shift);
    }

    @PostMapping("/deleteEmployeeScheduleById")
    public void deleteEmployeeSchedule(@RequestParam(value = "employeeId", defaultValue = "-1") int employeeId){
        employeeScheduleService.deleteEmployeeSchedule(employeeId);
    }

}
