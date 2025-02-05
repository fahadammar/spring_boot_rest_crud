package com.restcrud.example.restcrud.service;

import com.restcrud.example.restcrud.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> findAll();

    Employee findById(int theID);

    Employee save(Employee employeeToSave);

    void deleteByID(int theID);

}
