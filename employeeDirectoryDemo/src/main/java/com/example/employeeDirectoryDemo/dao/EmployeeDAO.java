package com.example.employeeDirectoryDemo.dao;

import com.example.employeeDirectoryDemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

     List<Employee> findAll();

     Employee findById(int employeeId);

     Employee saveEmployee(Employee employee);

     void deleteById(int employeeId);

}
