package com.mazenscode.cruddemo.dao;

import com.mazenscode.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional // from springframework
    public void save(Student student){
        entityManager.persist(student);
    }

    @Override // Here we didnt use @Transactional because we are making a query
    public Student findByID(Integer id){
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll(){
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName){

        TypedQuery<Student> theQuery = entityManager.createQuery(
                "From Student where lastName = :theData", // :theData is a placeholder
                Student.class
        );
        theQuery.setParameter("theData", lastName);
        return theQuery.getResultList();
    }

    @Override
    @Transactional // as we are making an update, we use @Transactional
    public void updateStudent(Student student){
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(Integer id){
        Student st = entityManager.find(Student.class, id);
        entityManager.remove(st);
    }

    @Override
    @Transactional
    public int deleteAllStudents(){
        int numRowsAffected = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return numRowsAffected;
    }

}
