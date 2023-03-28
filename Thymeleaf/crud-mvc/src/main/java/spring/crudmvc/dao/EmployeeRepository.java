package spring.crudmvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.crudmvc.entity.Employee;



public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// that's it ... no need to write any code LOL!
	
}
