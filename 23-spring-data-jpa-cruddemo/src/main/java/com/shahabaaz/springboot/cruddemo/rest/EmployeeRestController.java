package com.shahabaaz.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shahabaaz.springboot.cruddemo.entity.Employee;
import com.shahabaaz.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;
	
	
	// read all
	@GetMapping("/employees")
	public List<Employee> findAll() {
		
		return employeeService.findAll();
		
	}
	
	// read one
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployeeById(@PathVariable int employeeId) {
		
		Employee theEmployee = employeeService.findById(employeeId);
		
		if (theEmployee == null) {
			throw new RuntimeException("Employee id not found: " + employeeId);
		}
		return theEmployee;
	}
	
	// insert
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		
		theEmployee.setId(0);
		
		employeeService.save(theEmployee);
		
		return theEmployee;
	}
	
	// update
	@PutMapping("/employees") 
	public Employee update(@RequestBody Employee theEmployee) {
		
		employeeService.save(theEmployee);
		
		return theEmployee;
		
	}
	
	// delete
	@DeleteMapping("/employees/{employeeId}")
	public String delete(@PathVariable int employeeId) {
		
		employeeService.deleteById(employeeId);
		
		return "Deleted employee id: " + employeeId;
		
	}
	
	
	
	
}
