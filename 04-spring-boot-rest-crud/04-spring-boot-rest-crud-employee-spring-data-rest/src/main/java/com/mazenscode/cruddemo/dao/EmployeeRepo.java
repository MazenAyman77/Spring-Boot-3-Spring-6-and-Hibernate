package com.mazenscode.cruddemo.dao;

import com.mazenscode.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// entity type, PR. KEY Type
@RepositoryRestResource(path = "members")
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
