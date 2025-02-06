package com.restcrud.example.restcrud.dao;

import com.restcrud.example.restcrud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="employee_repo")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
 // We get the crud methods automatically, no need to write them

}

// JpaRepository<Entity Type, Primary Key (also its data type to write)>
