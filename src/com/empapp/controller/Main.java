package com.empapp.controller;

import com.empapp.dao.Employee;
import com.empapp.exceptions.EmployeeNotFoundException;
import com.empapp.service.EmployeeService;
import com.empapp.service.EmployeeServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Implement service
        EmployeeService employeeService = new EmployeeServiceImpl();

        // Add Employee
        Employee employee = new Employee("Umesh", 98000);
//        employeeService.addEmployee(employee);

        // Update Employee
        try {
            Employee emp = employeeService.getById(1).get();
            emp.setSalary(9000);
            employeeService.updateEmployee(1, emp);
        } catch (EmployeeNotFoundException ex) {
            ex.printStackTrace();
        }

        // Delete Employee
        employeeService.deleteEmployee(7);

        // Get All Employee
        List<Employee> employeeList = employeeService.getAll();
        employeeList.forEach(e -> System.out.println(e));

        // Get by ID Employee
        Employee e = employeeService.getById(4).get();
        System.out.println("Id: " + 4 + "Employee: " + e.toString());
    }
}
