package spring.crudmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring.crudmvc.entity.Employee;
import spring.crudmvc.service.EmployeeService;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	
	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService=employeeService;
	}

	@GetMapping("/list")
	public String listEmployees(Model theModel) {

		// add to the spring model
		List<Employee> theEmployees=employeeService.findAll();
		theModel.addAttribute("employees", theEmployees);

		return "employees/list";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Employee newEmployee=new Employee();
		theModel.addAttribute("employee",newEmployee);
		return "employees/employee-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
		employeeService.save(theEmployee);
		return "redirect:/employees/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String updateEmployee(@RequestParam("employeeId") int id,Model theModel) {
		Employee theEmployee=employeeService.findById(id); 
		theModel.addAttribute("employee",theEmployee);
		return "employees/employee-form";
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("employeeId") int id) {
		employeeService.deleteById(id);
		return "redirect:/employees/list";
	}
}
