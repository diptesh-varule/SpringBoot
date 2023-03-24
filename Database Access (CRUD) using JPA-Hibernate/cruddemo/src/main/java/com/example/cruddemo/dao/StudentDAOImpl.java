package com.example.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
@Transactional
public class StudentDAOImpl implements StudentDAO{
	private EntityManager entityManager;
	
	@Autowired
	public StudentDAOImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	public void save(Student theStudent) {
		entityManager.persist(theStudent);
	}

	@Override
	public Student findByID(Integer id) {
		return entityManager.find(Student.class, id);
	}

	@Override
	public List<Student> findAll() {
		TypedQuery<Student> theQuery=entityManager.createQuery("FROM Student order by lastname",Student.class);
		return theQuery.getResultList();
	}

	@Override
	public List<Student> findByLastname(String lastname) {
		
		TypedQuery<Student> theQuery=entityManager.createQuery("FROM Student where lastname=:data",Student.class);
		theQuery.setParameter("data",lastname);
		return theQuery.getResultList();
	}

	@Override
	public void update(Student theStudent) {
		entityManager.merge(theStudent);
		
	}

	@Override
	public void delete(Integer id) {
		Student theStudent=entityManager.find(Student.class,id);
		entityManager.remove(theStudent);
		
	}


	
	
}
