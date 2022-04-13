package com.Cinema.CinemaManagerSystem.Service;

import com.Cinema.CinemaManagerSystem.DataAccessObject.CustomerDAO;
import com.Cinema.CinemaManagerSystem.Models.Customer;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

// Toros

@Service
public class CustomerService {

    @Autowired
    CustomerDAO customerDAO;
    Customer customer;
    ArrayList<Customer> customers;

    /**
     * Sends information to DAO class for inserting new customer
     *
     * @param customerID
     * @param customerName
     * @param customerEmail
     */
    public void insertNewCustomer(int customerID, String customerName, String customerEmail) {
        customerDAO.insertNewCustomer(customerID, customerName, customerEmail);
    }

    /**
     * Sends information to DAO class for deleteing customer from database, by ID
     *
     * @param idDelete
     */
    public void deleteCustomerByID(int idDelete) {
        customerDAO.deleteCustomerByID(idDelete);
    }

    /**
     * @param customerID
     * @return gson String with one customer info, based on ID, Sends it to DAO class
     */
    public String downloadOneCustomerByID(int customerID) {
        Gson gson = new Gson();
        customer = customerDAO.downloadOneCustomerByID(customerID);
        String customerString = gson.toJson(customer);
        return customerString;
    }
}


















