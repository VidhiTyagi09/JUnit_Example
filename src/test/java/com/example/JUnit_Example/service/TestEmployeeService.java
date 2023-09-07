package com.example.JUnit_Example.service;

import com.example.JUnit_Example.models.Address;
import com.example.JUnit_Example.models.Employee;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestEmployeeService {
    @InjectMocks
    static EmployeeService employeeService;

    @BeforeAll
    static void setUp() {
        employeeService = new EmployeeService();
        employeeService.empList = new ArrayList<>();
        employeeService.employeeSet = new HashSet<>();
        employeeService.employeeHashMap = new HashMap<>();
    }

    @Test
    void insertEmployeeTest() {
        Employee employeeToAdd = new Employee();
        employeeToAdd.setId(123456789);
        employeeToAdd.setFirstName("Vidhi");
        employeeToAdd.setLastName("Tyagi");
        Address addressVidhi = new Address();
        addressVidhi.setCity("Meerut");
        addressVidhi.setCountry("India");
        addressVidhi.setPincode(250001);
        addressVidhi.setAddress("Shradhapuri");
        employeeToAdd.setAddress(addressVidhi);

        employeeService.insertEmployee(employeeToAdd);
        assertEquals(employeeService.empList.size(), 1);
    }

    @Test
    void getAllEmployees() {
        this.insertEmployeeTest();
        System.out.println(employeeService.empList);
        int size = employeeService.getAllEmployees().size();
        assertEquals(size,1);
    }

    @Test
    void updateEmployee() {
        this.insertEmployeeTest();
        Employee employeeToUpdate = new Employee();
        employeeToUpdate.setId(123456789);
        employeeToUpdate.setFirstName("Vidhi");
        employeeToUpdate.setLastName("Tyagi");
        Address addressVidhi = new Address();
        addressVidhi.setCity("Meerut");
        addressVidhi.setCountry("India");
        addressVidhi.setPincode(250001);
        addressVidhi.setAddress("Shradhapuri");
        employeeToUpdate.setAddress(addressVidhi);
        employeeService.updateEmployee(employeeToUpdate);
        assertTrue(employeeService.empList.contains(employeeToUpdate));
    }

    @Test
    void getEmployeeById() {
        this.insertEmployeeTest();
        long id = 123456789;
        assertEquals(123456789, employeeService.getEmployeeById(id).getId());
    }
    @Test
    void deleteEmployee() {
        this.insertEmployeeTest();
        long id = 123456789;
        employeeService.deleteEmployee(id);
        assertEquals(0, employeeService.empList.size());
    }
}
