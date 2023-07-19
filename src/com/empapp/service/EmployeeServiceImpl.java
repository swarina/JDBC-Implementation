package com.empapp.service;

import com.empapp.dao.Employee;
import com.empapp.dao.EmployeeDao;
import com.empapp.dao.EmployeeDaoImplJdbc;
import com.empapp.exceptions.EmployeeNotFoundException;

import java.util.List;
import java.util.Optional;

public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeDao employeeDao;

    public EmployeeServiceImpl() {
        this.employeeDao = new EmployeeDaoImplJdbc();
    }

    @Override
    public List<Employee> getAll() {
        long start = System.currentTimeMillis();
        List<Employee> employeeList = employeeDao.getAll();
        long end = System.currentTimeMillis();

        System.out.println("Time taken to execute the getAll: " + (end - start) + " ms");
        return employeeList;
    }

    @Override
    public void addEmployee(Employee employee) {
        // Validation
        employeeDao.addEmployee(employee);
    }

    @Override
    public Optional<Employee> getById(int id) {
        Optional<Employee> optionalEmployee = employeeDao.getById(id);

        Employee e = optionalEmployee.orElseThrow(() -> new EmployeeNotFoundException("Emp with id " + id + " is not found"));
        return optionalEmployee;
    }

    @Override
    public void updateEmployee(int id, Employee employee) {
        employeeDao.updateEmployee(id, employee);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeDao.deleteEmployee(id);
    }
}
