package com.mazenscode.cruddemo.service;

import com.mazenscode.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
    Employee findByID(Integer id);
    Employee save(Employee employee);
    void deleteByID(Integer id);

}
