package com.Cinema.CinemaManagerSystem;

import com.Cinema.CinemaManagerSystem.DataAccessObject.EmployeeDAO;
import com.Cinema.CinemaManagerSystem.Models.Employee;
import com.Cinema.CinemaManagerSystem.Service.EmployeeService;
import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

        @Mock
        private EmployeeDAO employeeDAO;

        @Mock
        private ArrayList<Employee> employees;

    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void downloadOneEmployeeByID() {
        //input
        Mockito.when(employeeDAO.downloadOneEmployeeByID(1)).thenReturn(new Employee(1,"Igor","0123456", "igor@gmail.com"));
        //when (action)
        Employee igor = employeeDAO.downloadOneEmployeeByID(1);
        //result
        assertEquals("Igor", igor.getEmployeeName());
    }

    @Test
    void downloadOneEmployeeByID2(){
        //input
        Mockito.when(employeeDAO.downloadOneEmployeeByID(1)).thenReturn(new Employee(1,"Igor","0123456", "igor@gmail.com"));
        EmployeeService service = new EmployeeService();
        service.setEmployeeDAO(employeeDAO);
        //when
        String jsonString = service.downloadOneEmployeeByID(1);
        //result
        assertEquals("{\"employeeID\":1,\"employeeName\":\"Igor\",\"employeeTel\":\"0123456\",\"employeeEmail\":\"igor@gmail.com\"}", jsonString);
    }

    @Test
    void downloadAllEmployees() {
        //input
        ArrayList<Employee> ints = new ArrayList<Employee>();
        ints.add(new Employee(1, "Toros", "083436", "TORS@GMAIL.COM"));
        ints.add(new Employee(2, "lISA", "083436", "TORS@GMAIL.COM"));
        Mockito.when(employeeDAO.downloadAllEmployees()).thenReturn(ints);
        EmployeeService service = new EmployeeService();
        service.setEmployeeDAO(employeeDAO);
        //when
        String jsonString = service.downloadAllEmployees();
        //result
        assertEquals("[{\"employeeID\":1,\"employeeName\":\"Toros\",\"employeeTel\":\"083436\",\"employeeEmail\":\"TORS@GMAIL.COM\"},{\"employeeID\":2,\"employeeName\":\"lISA\",\"employeeTel\":\"083436\",\"employeeEmail\":\"TORS@GMAIL.COM\"}]", jsonString);
    }

    @Test
    void updateEmployee() {
    }
}