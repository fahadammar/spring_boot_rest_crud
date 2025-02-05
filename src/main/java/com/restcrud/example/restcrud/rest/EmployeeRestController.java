package com.restcrud.example.restcrud.rest;

import com.restcrud.example.restcrud.entity.Employee;
import com.restcrud.example.restcrud.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private final EmployeeServiceImpl employeeServiceImplementation;

    @Autowired
    public EmployeeRestController(EmployeeServiceImpl theEmployeeServiceImplementation) {
        this.employeeServiceImplementation = theEmployeeServiceImplementation;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeServiceImplementation.findAll();
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        /*
        * Just in case they pass an ID in JSON set ID to 0
        * This is to force to save of new item instead of update
        */
        theEmployee.setId(0);
        return employeeServiceImplementation.save(theEmployee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        return employeeServiceImplementation.save(theEmployee);
    }

    @DeleteMapping("/employees/{employeeID}")
    public String deleteEmployee(@PathVariable int employeeID){
        Employee tempEemployee = employeeServiceImplementation.findById(employeeID);
        if(tempEemployee == null){
            throw new RuntimeException("Employee Not Found " + employeeID);
        }
        employeeServiceImplementation.deleteByID(employeeID);
        return "Deleted The Employee, ID -> " + employeeID;
    }
}
