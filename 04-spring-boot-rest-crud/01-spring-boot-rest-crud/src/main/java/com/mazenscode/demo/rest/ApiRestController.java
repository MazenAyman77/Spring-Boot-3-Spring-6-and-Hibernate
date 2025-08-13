package com.mazenscode.demo.rest;

import com.mazenscode.demo.entity.Student;
import com.mazenscode.demo.exeptions.StudentNotFoundExeption;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiRestController {

    private List<Student> theStudents;

    @PostConstruct
    public void makeStudents(){

        theStudents = new ArrayList<>();
        theStudents.add(new Student("hazem", "sameh"));
        theStudents.add(new Student("sara", "ahmed"));
        theStudents.add(new Student("jana", "khaled"));

    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return theStudents;
    }

    @GetMapping("/getStudent/{studentID}")
    public Student getStudent(@PathVariable int studentID){

        if(studentID >= theStudents.size() || studentID < 0){
            throw new StudentNotFoundExeption("student not found : " + studentID);
        }

        return theStudents.get(studentID);
    }

}
