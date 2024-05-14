package com.example.employeeDirectoryDemo.dao;

import com.example.employeeDirectoryDemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDAOImpl implements EmployeeDAO{


    // define field for entityManager
    private EntityManager entityManager;


    // set upp constructor injection to inject the entity manager
    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Employee> findAll() {

        // create query to return
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);

        // execute the query and get list of employees
        List<Employee> employees = query.getResultList();

        // return list of employees
        return employees;
    }

    @Override
    public Employee findById(int employeeId) {

        return entityManager.find(Employee.class,employeeId);
    }

    @Override
    public Employee saveEmployee(Employee employee) {

       // save employee  ( if merge return if id == 0 then save/insert  else update)
        Employee dbEmployee = entityManager.merge(employee);

        // return the dbEmployee
        return dbEmployee;


    }



    @Override
    public void deleteById(int employeeId) {

        // find the employee with this id
        Employee employee = entityManager.find(Employee.class,employeeId);

        // remove the employee
        entityManager.remove(employee);

    }
}
