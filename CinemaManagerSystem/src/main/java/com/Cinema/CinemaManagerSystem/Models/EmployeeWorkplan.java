package com.Cinema.CinemaManagerSystem.Models;

import org.springframework.stereotype.Component;

@Component
public class EmployeeWorkplan {
    private String employeeName;
    private String workstation;
    private String task;
    private String shift;
    private boolean isAvailable;

    public EmployeeWorkplan(){
    }


    public EmployeeWorkplan(String employeeName, String workstation, String task, String shift, boolean isAvailable){
        this.employeeName = employeeName;
        this.workstation = workstation;
        this.task = task;
        this.shift = shift;
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return "EmployeeWorkplan{" +
                "employeeName='" + employeeName + '\'' +
                ", workstation='" + workstation + '\'' +
                ", task='" + task + '\'' +
                ", shift='" + shift + '\'' +
                ", isAvailable='" + isAvailable + '\'' +
                '}';
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getWorkstation() {
        return workstation;
    }

    public void setWorkstation(String workstation) {
        this.workstation = workstation;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public boolean isAvailable(){
        return isAvailable;
    }

    public void setAvailable(boolean available){
         isAvailable = available;
    }
}

