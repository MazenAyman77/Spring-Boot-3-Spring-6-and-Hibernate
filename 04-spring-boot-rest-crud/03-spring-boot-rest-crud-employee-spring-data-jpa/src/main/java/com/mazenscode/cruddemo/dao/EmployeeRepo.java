package com.mazenscode.cruddemo.dao;

import com.mazenscode.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

// entity type, PR. KEY Type
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
