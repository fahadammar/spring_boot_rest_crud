package com.restcrud.example.restcrud.service;

import com.restcrud.example.restcrud.dao.EmployeeRepository;
import com.restcrud.example.restcrud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
        this.employeeRepository = theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theID) {
        Optional<Employee> result = employeeRepository.findById(theID);
        Employee employee = null;
        if(result.isPresent()){
            employee = result.get();
        } else {
            throw new RuntimeException("Sorry! could not find the ID " + theID);
        }
        return employee;
    }

    // REMOVED THE TRANSACTIONAL SINCE JPA_REPOSITORY PROVIDES THIS FUNCTIONALITY
    @Override
    public Employee save(Employee employeeToSave) {
        return employeeRepository.save(employeeToSave);
    }

    @Override
    public void deleteByID(int theID) {
        employeeRepository.deleteById(theID);
    }
}
