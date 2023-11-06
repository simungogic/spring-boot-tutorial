package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
    void deleteById(int id);
    Employee save(Employee employee);
    Employee findById(int id);
}
