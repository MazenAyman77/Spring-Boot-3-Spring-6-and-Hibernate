package com.mazenscode.cruddemo.service;

import com.mazenscode.cruddemo.dao.EmployeeRepo;
import com.mazenscode.cruddemo.entity.Employee;
import com.mazenscode.cruddemo.exceptions.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepo employeeRepo){
        this.employeeRepo = employeeRepo;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee findByID(Integer id) {

        Optional<Employee> result = employeeRepo.findById(id);

        if(result.isPresent()){
            return result.get();
        }
        else{
            throw new EmployeeNotFoundException("this employee not found : " + id);
        }
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public void deleteByID(Integer id) {
        employeeRepo.deleteById(id);
    }

}
