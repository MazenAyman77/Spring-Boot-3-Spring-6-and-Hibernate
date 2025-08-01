package com.mazenscode.cruddemo;

import com.mazenscode.cruddemo.dao.StudentDAO;
import com.mazenscode.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			// createStudent(studentDAO);
			createMultipleStudents(studentDAO);
			// findingStudent(studentDAO);
			// findAllStudents(studentDAO);
			// queryForStudentByLastName(studentDAO);
			// updateStudent(studentDAO);
			// deleteStudent(studentDAO);
			// deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO){
		System.out.println("Deleting all studeents ..................");
		int rows = studentDAO.deleteAllStudents();
		System.out.println("Number of Rows affected : " + rows);
	}

	private void deleteStudent(StudentDAO studentDAO){

		int id = 2;
		System.out.println("deleting student : " + studentDAO.findByID(id) + " ................");
		studentDAO.delete(id);
		System.out.println("Succesful");

	}

	private void updateStudent(StudentDAO studentDAO){

		int stID = 3;
		System.out.println("Getting student with id :  " + stID);
		Student theStudent = studentDAO.findByID(stID);
		System.out.println("Student Details : " + theStudent);

		System.out.println("Updating student first name to Scooby ...........");
		theStudent.setFirstName("Scooby");
		studentDAO.updateStudent(theStudent);

		System.out.println("The student updated details :  " + studentDAO.findByID(stID));

	}

	private void queryForStudentByLastName(StudentDAO studentDAO){

		List<Student> theStudent = studentDAO.findByLastName("sokkar");

		for(Student st : theStudent){
			System.out.println(st);
		}

	}

	private void findAllStudents(StudentDAO studentDAO){

		List<Student> students = studentDAO.findAll();

		for(Student st : students){
			System.out.println(st);
		}

	}

	private void findingStudent(StudentDAO studentDAO){
		System.out.println("creating new student object ......................");

		Student theStudent = new Student(
				"loay",
				"naser",
				"loay@naser"
		);

		System.out.println("saving the student object ......................");

		studentDAO.save(theStudent);

		System.out.println("The Student id is : " + theStudent.getId());

		int theID = theStudent.getId();

		System.out.println("Retrieving Student details from DB ............. ");

		Student stDetails = studentDAO.findByID(theID);

		System.out.println(stDetails);

	}

	private void createMultipleStudents(StudentDAO studentDAO){
		System.out.println("creating multiple student ............");
		Student ali = new Student("ali", "akram", "ali@akram");
		Student noha = new Student("noha", "salem", "noha@salem");
		Student hatem = new Student("hatem", "sokkar", "hatem@sokkar");

		System.out.println("saving them ..................");
		studentDAO.save(ali);
		studentDAO.save(noha);
		studentDAO.save(hatem);
	}

	private void createStudent(StudentDAO studentDAO){

		System.out.println("creating new student object ......................");

		Student theStudent = new Student(
				"hamada",
				"lolo",
				"hamadalolo@mada"
		);

		System.out.println("saving the student object ......................");

		studentDAO.save(theStudent);

		System.out.println("The Student id is : " + theStudent.getId());

	}

}
