package com.empapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

// DAO needs connection
// Object -> ConnectionFactory
public class EmployeeDaoImplJdbc implements EmployeeDao {
    private Connection connection;

    public EmployeeDaoImplJdbc() {
        connection = ConnectionFactory.getConnection();
    }
    @Override
    public List<Employee> getAll() {
        List<Employee> employeeList = new LinkedList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("Select * from emp");
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                Employee e = new Employee(rs.getInt(1), rs.getString(2), rs.getDouble(3));
                employeeList.add(e);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return employeeList;
    }

    @Override
    public void addEmployee(Employee employee) {
        try {
            PreparedStatement statement = connection.prepareStatement("Insert into emp (name, salary) values(?, ?)");
            statement.setString(1, employee.getName());
            statement.setDouble(2, employee.getSalary());

            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Optional<Employee> getById(int id) {
        Employee e = null;
        try {
            PreparedStatement statement = connection.prepareStatement("Select * from emp where id = ?");
            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                e = new Employee(rs.getInt("id"), rs.getString("name"), rs.getDouble("salary"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return Optional.ofNullable(e);
    }

    @Override
    public void deleteEmployee(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("Delete from emp where id = ?");
            statement.setInt(1, id);

            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void updateEmployee(int id, Employee employee) {
        try {
            PreparedStatement statement = connection.prepareStatement("Update emp set salary = ? where id = ?");
            statement.setDouble(1, employee.getSalary());
            statement.setInt(2, employee.getId());

            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
