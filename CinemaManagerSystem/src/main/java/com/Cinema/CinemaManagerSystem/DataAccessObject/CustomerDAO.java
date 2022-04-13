package com.Cinema.CinemaManagerSystem.DataAccessObject;

import com.Cinema.CinemaManagerSystem.Models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Data Access Object for customer table. Not in use right now but important for later scaling.
 */
@Repository
public class CustomerDAO { // Toros
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private String error;

    public CustomerDAO() {
        this.error = "no";
        this.jdbcTemplate = new JdbcTemplate();
    }

    /**
     * Inserts a new customer in the database
     * @param customerID int
     * @param customerName String
     * @param customerEmail String
     */
    public  void insertNewCustomer(int customerID, String customerName, String customerEmail) {

        String query = "INSERT INTO customers VALUES (null, ?, ?);";

        int result = jdbcTemplate.update(query, customerName, customerEmail);

        if (result > 0) {
            System.out.println(result + "customer added to database");
            this.error = "customer added to database";
        }
    }

    /**
     * deletes a customer from the database by ID
     * @param customerID int
     */
    public void deleteCustomerByID(int customerID){
        String query = "DELETE FROM customers WHERE customer_ID = ?;";
        int result = jdbcTemplate.update(query, customerID);

        if (result > 0) {
            System.out.println(result + "customer deleted from database");
            this.error = "customer deleted from database";
        }
    }

    /**
     * gets a customer from the database by ID
     * @param customerID int
     * @return Customer class
     */
    public Customer downloadOneCustomerByID(int customerID) {
        String query = "SELECT * FROM customers WHERE customer_ID = ?;";
        Customer customer = this.jdbcTemplate.queryForObject(query, new RowMapper<Customer>() {
            @Override
            public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
                Customer innerCustomer = new Customer(
                        rs.getInt("customer_ID"),
                        rs.getString("customer_name"),
                        rs.getString("customer_email")
                );
                return innerCustomer;
            }
        }, customerID);
        return customer;
    }

    //for testing purposes
    public String getError() {
        return error;
    }
    //for testing purposes
    public void setError(String error) {
        this.error = error;
    }
}
