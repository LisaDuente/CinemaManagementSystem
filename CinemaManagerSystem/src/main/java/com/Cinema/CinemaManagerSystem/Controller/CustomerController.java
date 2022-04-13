package com.Cinema.CinemaManagerSystem.Controller;

import com.Cinema.CinemaManagerSystem.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController { // Toros

    @Autowired
    CustomerService customerService;
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // for reference:
    // int customerID, String customerName, String customerEmail
    // customerID, customerName, customerEmail

    // methods:
    // insertCustomer()
    // deleteCustomerByID()
    // downloadOneCustomerByID()
    /**
     * Sends request to insert a customer to database
     * @param customerID int for customerID of customer we want to insert
     * @param customerName name of the customer
     * @param customerEmail email of the customer
     */
    @GetMapping("/insertNewCustomer")
    public void insertNewCustomer(@RequestParam(value = "customer_ID", defaultValue = "-1") int customerID, @RequestParam(value = "customer_name", defaultValue = "noCustomerName") String customerName, @RequestParam(value = "customer_email", defaultValue = "noCustomerEmail") String customerEmail) {
        customerService.insertNewCustomer(customerID, customerName, customerEmail);
    }
    /**
     * Sends request to delete a customer by ID from database
     * @param customerID int for customerID of customer we want to delete
     */
    @GetMapping("/deleteCustomerByID")
    public void deleteCustomerByID(@RequestParam(value = "customer_ID", defaultValue = "-1") int customerID) {
        customerService.deleteCustomerByID(customerID);
    }
    /**
     * Sends request to download a customer by ID from database
     * @param customerID int for customerID of customer we want to download
     */
    @GetMapping("/downloadOneCustomerByID")
    public String downloadOneCustomerByID(@RequestParam(value = "customer_ID", defaultValue = "-1") int customerID, @RequestParam(value = "customer_name", defaultValue = "noCustomerName") String customerName, @RequestParam(value = "customer_email", defaultValue = "noCustomerEmail") String customerEmail) {
        return customerService.downloadOneCustomerByID(customerID);
    }
}
