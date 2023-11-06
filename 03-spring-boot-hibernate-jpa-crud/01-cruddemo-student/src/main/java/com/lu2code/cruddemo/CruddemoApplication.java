package com.lu2code.cruddemo;

import com.lu2code.cruddemo.dao.StudentDAO;
import com.lu2code.cruddemo.entity.Student;
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
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			//createStudent(studentDAO);
			createMultipleStudents(studentDAO);
			//readStudent(studentDAO);
			//findAllStudents(studentDAO);
			//findStudentsByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			//deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students...");
		int count = studentDAO.delete();
		System.out.println(count + " students deleted.");
	}


	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 2;
		System.out.println("Deleting student id: " + studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId = 1;
		Student student = studentDAO.findById(studentId);
		student.setFirstName("John");
		studentDAO.update(student);
		System.out.println(student);
	}

	private void findStudentsByLastName(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findByLastName("Mock");
		students.forEach(s -> System.out.println(s));
	}

	private void findAllStudents(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();
		students.forEach(s -> System.out.println(s));
	}

	private void readStudent(StudentDAO studentDAO) {
		Student student = new Student("Alois", "Mock", "alois.mock@gmail.com");
		studentDAO.save(student);
		int id = student.getId();
		System.out.println("Student's id: " + id);
		Student retrievedStudent = studentDAO.findById(id);
		System.out.println("Retrieved student: " + retrievedStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating 3 student object...");
		Student student1 = new Student("Ivan", "Gogic", "ivan.gogic@gmail.com");
		Student student2 = new Student("Marko", "Gogic", "marko.gogic@gmail.com");
		Student student3 = new Student("Petar", "Gogic", "petar.gogic@gmail.com");

		System.out.println("Saving the students...");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object...");
		Student student = new Student("Simun", "Gogic", "simun.gogic@gmail.com");

		System.out.println("Saving the student...");
		studentDAO.save(student);

		System.out.println("Saved student. Generated id: " + student.getId());
	}
}
