package com.mazenscode.cruddemo.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.mazenscode.cruddemo.entity.Employee;
import com.mazenscode.cruddemo.exceptions.EmployeeNotFoundException;
import com.mazenscode.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;
    private ObjectMapper objectMapper;

    @Autowired
    public EmployeeRestController (EmployeeService employeeService, ObjectMapper objectMapper){
        this.employeeService = employeeService;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/employees")
    public List<Employee> findAllEmployees(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{theID}")
    public Employee findEmployeeByID(@PathVariable int theID){

        Employee employee = employeeService.findByID(theID);

        if(employee == null){
            throw new EmployeeNotFoundException("this employee is not found ...");
        }

        return employee;
    }

    // adding new employee
    @PostMapping("/employees")
    public Employee addingEmployee(@RequestBody Employee employee){

        // in case the id is passed in JSON, set id to 0, to force a save to the object not to update
        employee.setId(0);
        return employeeService.save(employee);

    }

    // making a full update
    @PutMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee){

        Employee theEmployee = employeeService.findByID(employee.getId());
        if(theEmployee == null){
            throw new EmployeeNotFoundException("this employee is not found to be updated : " + employee);
        }

        return employeeService.save(employee);
    }

    //making a partial update
    @PatchMapping("/employees/{theID}")
    public Employee patchEmployee (@PathVariable int theID,
                                   @RequestBody Map<String, Object> patchPayload)
    {
        Employee employee = employeeService.findByID(theID);
        if(employee == null){
            throw new EmployeeNotFoundException("this employee not found : " + theID);
        }

        // as we don't want to change the id as it's a primary key
        if(patchPayload.containsKey("id")){
            throw new RuntimeException("Employee ID is not allowed in request body - " + theID);
        }

        Employee patchedEmployee = apply(patchPayload, employee);

        return employeeService.save(patchedEmployee);

    }

    private Employee apply(Map<String, Object> patchPayLoad, Employee tempEmployee){

        // convert employee object to json object node
        ObjectNode employeeNode = objectMapper.convertValue(tempEmployee, ObjectNode.class);

        // convert patch pay load to json object node
        ObjectNode patchNode = objectMapper.convertValue(patchPayLoad, ObjectNode.class);

        // merge the patch updates into the employee node
        employeeNode.setAll(patchNode);

        return objectMapper.convertValue(employeeNode, Employee.class);
    }

    @DeleteMapping("/employees/{theID}")
    public String deleteEmployee(@PathVariable int theID){

        Employee employee = employeeService.findByID(theID);
        if(employee == null){
            throw new EmployeeNotFoundException("this employee not found : " + theID);
        }

        employeeService.deleteByID(theID);
        return "Succesfullay deleted employee : " + theID;
    }

}
