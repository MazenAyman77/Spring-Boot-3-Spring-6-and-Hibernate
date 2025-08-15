package com.mazenscode.cruddemo.exceptions;

import com.mazenscode.cruddemo.entity.Employee;
import com.mazenscode.cruddemo.entity.ExceptionHandlerFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ExceptionHandlerFormat> employeeNotFound(EmployeeNotFoundException exe){

        ExceptionHandlerFormat error = new ExceptionHandlerFormat();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setBody("This Employee is not found ....");
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }



}
