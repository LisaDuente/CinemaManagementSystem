package com.Cinema.CinemaManagerSystem.Models;

import org.springframework.stereotype.Component;

@Component
public class Customer { // Toros

    private int customerID;         // int UN AI PK
    private String customerName;    // varchar(100)
    private String customerEmail;   // varchar(100)

    public Customer() {

    }

    public Customer(int customerID, String customerName, String customerEmail) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerID=" + customerID +
                ", customerName='" + customerName + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                '}';
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
}
