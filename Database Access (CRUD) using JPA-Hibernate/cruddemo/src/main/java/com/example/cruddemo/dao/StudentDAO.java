package com.example.cruddemo.dao;

import java.util.List;

import com.example.cruddemo.entity.Student;

public interface StudentDAO {
	public void save(Student theStudent);
	Student findByID(Integer id);
	
	List<Student> findAll();
	List<Student> findByLastname(String lastname);
	void update(Student theStudent);
	void delete(Integer id);
}
