package com.firealgo.completerestapidemoapp.service;

import com.firealgo.completerestapidemoapp.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int theId);

    void save(Employee theEmployee);

    void deleteById(int theId);

}
