package com.restcrud.example.restcrud.service;

import com.restcrud.example.restcrud.dao.EmployeeDao;
import com.restcrud.example.restcrud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao theEmployeeDAO) {
        this.employeeDao = theEmployeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public Employee findById(int theID) {
        return employeeDao.findById(theID);
    }

    @Transactional
    @Override
    public Employee save(Employee employeeToSave) {
        return employeeDao.save(employeeToSave);
    }

    @Transactional
    @Override
    public void deleteByID(int theID) {
        employeeDao.deleteByID(theID);
    }
}
