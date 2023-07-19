package com.empapp.service;

import com.empapp.dao.Employee;

import java.util.List;
import java.util.Optional;

// Service Layer invokes DAO Layer and have extra logic
public interface EmployeeService {
    public List<Employee> getAll();
    public void addEmployee(Employee employee);
    public Optional<Employee> getById(int id);
    public void updateEmployee(int id, Employee employee);
    public void deleteEmployee(int id);
}
