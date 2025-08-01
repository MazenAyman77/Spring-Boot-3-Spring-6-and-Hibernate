package com.mazenscode.cruddemo.dao;

import com.mazenscode.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);
    Student findByID(Integer id);
    List<Student> findAll();
    List<Student> findByLastName(String lastName);
    void updateStudent(Student student);
    void delete(Integer id);
    int deleteAllStudents();

}
