package com.example.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import java.util.List;
import com.example.cruddemo.dao.StudentDAO;
import com.example.cruddemo.dao.StudentDAOImpl;
import com.example.cruddemo.entity.Student;

@SpringBootApplication

public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	
	
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDao) {
		return runner -> {
			//readStudent(studentDao);
			createStudent(studentDao);
			//queryForStudents(studentDao);
			//queryForStudentByLastName(studentDao);
			//updateStudent(studentDao);
			//deleteStudent(studentDao);
		};
	}
	
	private void deleteStudent(StudentDAO studentDao) {
		studentDao.delete(1);
		
	}


	private void updateStudent(StudentDAO studentDao) {
		Student myStudent=studentDao.findByID(1);
		myStudent.setFirstname("Dips");
		studentDao.update(myStudent);
		
		System.out.println(myStudent);
	}


	private void queryForStudentByLastName(StudentDAO studentDao) {
			List<Student> theStudents=studentDao.findByLastname("Nemade");
			for(Student temp:theStudents) {
				System.out.println(temp);
			}
	}


	private void queryForStudents(StudentDAO studentDao) {
		List<Student> theStudents=studentDao.findAll();
		for(Student temp:theStudents) {
			System.out.println(temp);
		}
	}


	private void readStudent(StudentDAO studentDao) {
		Student myStudent=studentDao.findByID(3);
		System.out.println(myStudent.getEmail());
		
	}

	private void createStudent(StudentDAO studentDao) {
		//create the student object
		Student newStudent=new Student("Diptesh","Varule","dipteshvarule@gmail.com");
		
		//save the student object
		studentDao.save(newStudent);
		
		//display the id of student object
		System.out.println("Student id is : "+newStudent.getId());
		
	}
}
