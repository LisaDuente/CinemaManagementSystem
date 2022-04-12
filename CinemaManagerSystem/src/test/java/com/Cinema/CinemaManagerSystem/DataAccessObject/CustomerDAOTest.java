package com.Cinema.CinemaManagerSystem.DataAccessObject;

import com.Cinema.CinemaManagerSystem.Models.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.*;

// Toros
class CustomerDAOTest {

    @Mock
    JdbcTemplate jdbcTemplateMock;

    @Mock
    CustomerDAO customerDAOMock;

    @Mock
    //int customerID, String customerName, String customerEmail
    Customer testCustomer = new Customer(0, "test", "test@test.test");

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
        //int customerID, String customerName, String customerEmail
    void insertNewCustomer() {
        // setup
        String query = "INSERT INTO customers VALUES (0, ?, ?);";
        int customerID = 0;
        String customerName = "test01";
        String customerEmail = "test@test.test";
        Mockito.when(jdbcTemplateMock.update(query, customerID, customerName, customerEmail)).thenReturn(1);

        // action
        int i = jdbcTemplateMock.update(query, customerID, customerName, customerEmail);
        // result
        assertEquals(1, i);
        Mockito.verify(jdbcTemplateMock).update(query, customerID, customerName, customerEmail);
    }

    @Test
    void deleteCustomerByID() {
    }

    @Test
    void downloadOneCustomerByID() {
        // setup
        String query = "SELECT * FROM customers WHERE customer_ID = ?;";
        Mockito.when(customerDAOMock.downloadOneCustomerByID(99)).thenReturn(testCustomer);

        // action
        Customer c = customerDAOMock.downloadOneCustomerByID(0);
        // result
        assertEquals(testCustomer, c);
        Mockito.verify(customerDAOMock).downloadOneCustomerByID(0);
    }

    @Test
    void getError() {
    }

    @Test
    void setError() {
    }
}