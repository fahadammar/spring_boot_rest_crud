package com.restcrud.example.restcrud.dao;

import com.restcrud.example.restcrud.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDao{
    private final EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
        this.entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);
        return theQuery.getResultList();
    }

    @Override
    public Employee findById(int theID) {
        return entityManager.find(Employee.class, theID);
    }

    @Override
    public Employee save(Employee employeeToSave) {
        // If ID == 0 then insert or update else update
        return entityManager.merge(employeeToSave);
    }

    @Override
    public void deleteByID(int theID) {
        Employee employeeToRemove = entityManager.find(Employee.class, theID);
        entityManager.remove(employeeToRemove);
    }
}

// NOTE: We are not using the @Transactional annotation, we are going to use that in the service layer