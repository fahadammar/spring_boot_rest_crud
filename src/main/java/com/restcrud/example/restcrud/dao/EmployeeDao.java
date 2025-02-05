package com.restcrud.example.restcrud.dao;

import com.restcrud.example.restcrud.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> findAll();

    Employee findById(int theID);

    Employee save(Employee employeeToSave);

    void deleteByID(int theID);
}
