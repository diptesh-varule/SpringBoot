package springboot.restcrud.dao;

import java.util.List;

import springboot.restcrud.entity.Employee;

public interface EmployeeDao {
	List<Employee> findAll();
	Employee findByID(int id);
	Employee save(Employee theEmployee);
	void deleteByID(int id);
}
