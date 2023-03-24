package springboot.restcrud.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import springboot.restcrud.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDaoImpl(EntityManager entityManager) {
		this.entityManager=entityManager;
	}
	
	@Override
	public List<Employee> findAll() {
		TypedQuery<Employee> theQuery=entityManager.createQuery("from Employee",Employee.class);
		List<Employee> employees=theQuery.getResultList();
		return employees;
	}

	@Override
	public Employee findByID(int id) {
		Employee emp=entityManager.find(Employee.class,id);
		return emp;
	}

	@Override
	public Employee save(Employee theEmployee) {
		Employee emp=entityManager.merge(theEmployee);
		return emp;
	}

	@Override
	public void deleteByID(int id) {
		Employee emp=entityManager.find(Employee.class,id);
		entityManager.remove(emp);
	}

}
