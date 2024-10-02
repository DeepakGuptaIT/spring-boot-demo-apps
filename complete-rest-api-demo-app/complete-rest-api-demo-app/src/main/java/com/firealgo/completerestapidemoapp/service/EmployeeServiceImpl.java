package com.firealgo.completerestapidemoapp.service;

import com.firealgo.completerestapidemoapp.dao.EmployeeRepository;
import com.firealgo.completerestapidemoapp.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;


    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
        repository = theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {

        final var employeeList = repository.findAll();
        System.out.println("employeeList =>" + employeeList);
        return employeeList;
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = repository.findById(theId);

        Employee theEmployee = null;

        if (result.isPresent()) {
            theEmployee = result.get();
        } else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + theId);
        }

        return theEmployee;
    }

    @Override
    public void save(Employee theEmployee) {
        System.out.println(theEmployee);
        repository.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        repository.deleteById(theId);
    }

}






