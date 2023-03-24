package springboot.restcrud.service;

import java.util.List;
import springboot.restcrud.entity.Employee;


public interface EmployeeService {
	List<Employee> findAll();
	Employee findByID(int id);
	Employee save(Employee theEmployee);
	void deleteByID(int id);
}
