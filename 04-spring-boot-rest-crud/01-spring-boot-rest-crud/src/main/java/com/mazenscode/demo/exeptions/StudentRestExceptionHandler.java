package com.mazenscode.demo.exeptions;

import com.mazenscode.demo.rest.StudentErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException (StudentNotFoundExeption exe){

        // create student error response
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exe.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // return response entity
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

    }

    // add another exception handler to catch any type of exceptions

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handlingExceptions (Exception exe){

        // create student error response
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exe.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // return response entity
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

    }

}
