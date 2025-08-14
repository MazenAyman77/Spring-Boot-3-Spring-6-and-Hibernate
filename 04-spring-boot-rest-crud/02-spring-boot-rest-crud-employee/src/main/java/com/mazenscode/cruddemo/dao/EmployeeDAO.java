package com.mazenscode.cruddemo.dao;

import com.mazenscode.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
    Employee findByID(Integer id);
    Employee save(Employee employee);
    void deleteByID(Integer id);

}
