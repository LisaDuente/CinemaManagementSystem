package com.Cinema.CinemaManagerSystem.Service;

import com.Cinema.CinemaManagerSystem.DataAccessObject.CustomerDAO;
import com.Cinema.CinemaManagerSystem.Models.Customer;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomerService { // Toros
    @Autowired
    CustomerDAO customerDAO;
    Customer customer;
    ArrayList<Customer> customers;

    public void insertNewCustomer(int customerID, String customerName, String customerEmail) {
        customerDAO.insertNewCustomer(customerID, customerName, customerEmail);
    }

    public void deleteCustomerByID(int idDelete) {
        customerDAO.deleteCustomerByID(idDelete);
    }

    public String downloadOneCustomerByID(int customerID){
        Gson gson = new Gson();
        customer = customerDAO.downloadOneCustomerByID(customerID);
        String customerString = gson.toJson(customer);
        return customerString;
    }

}


















