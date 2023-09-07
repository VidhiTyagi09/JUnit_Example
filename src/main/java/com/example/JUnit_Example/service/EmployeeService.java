package com.example.JUnit_Example.service;

import com.example.JUnit_Example.models.Employee;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

@Service
public class EmployeeService {
    public List<Employee> empList;
    public Set<Employee> employeeSet;
    public HashMap<Long,Employee> employeeHashMap;


    public void insertEmployee(Employee emp)
    {
        // employee is already present
        if(this.employeeSet.contains(emp) || this.employeeHashMap.containsKey(emp.getId()))
            return;

        //employee is not present and we need to add employee.
        this.empList.add(emp);
        this.employeeSet.add(emp);
        this.employeeHashMap.put(emp.getId(),emp);
    }
    public void updateEmployee(Employee emp)
    {
        //find the employee using hashmap
        Employee oldEmployee = this.employeeHashMap.get(emp.getId());

        if(oldEmployee != null)
        {
            // update the employee
            oldEmployee.setId(emp.getId());
            oldEmployee.setFirstName(emp.getFirstName());
            oldEmployee.setLastName(emp.getLastName());
            oldEmployee.setAddress(emp.getAddress());


            //add this new updated employee.
            this.empList.add(oldEmployee);
            this.employeeSet.add(oldEmployee);
            this.employeeHashMap.put(oldEmployee.getId(),oldEmployee);
        }
    }
    public void deleteEmployee(long id)
    {
        //find the employee.
        Employee employeeToDelete = this.employeeHashMap.get(id);
        if(employeeToDelete != null)
        {
            this.empList.remove(employeeToDelete);
            this.employeeSet.remove(employeeToDelete);
            this.employeeHashMap.remove(id);
        }
    }
    public  List<Employee> getAllEmployees()
    {
        return this.empList;
    }
    public  Employee getEmployeeById(long id)
    {
        //get employee by id using hashmap
        Employee employee = this.employeeHashMap.get(id);

        return employee;
    }
}