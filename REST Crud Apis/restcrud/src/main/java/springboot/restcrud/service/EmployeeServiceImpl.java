package springboot.restcrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import springboot.restcrud.dao.EmployeeDao;
import springboot.restcrud.entity.Employee;
@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeDao employeeDao;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDao employeeDao) {
		this.employeeDao=employeeDao;
	}
	
	@Override
	public List<Employee> findAll() {
		return employeeDao.findAll();
	}

	@Override
	public Employee findByID(int id) {
		// TODO Auto-generated method stub
		return employeeDao.findByID(id);
	}

	@Transactional
	@Override
	public Employee save(Employee theEmployee) {
		// TODO Auto-generated method stub
		return employeeDao.save(theEmployee);
	}

	@Transactional
	@Override
	public void deleteByID(int id) {
		employeeDao.deleteByID(id);
	}

}
