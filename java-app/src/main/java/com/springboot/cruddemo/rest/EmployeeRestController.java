package com.springboot.cruddemo.rest;

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

import com.springboot.cruddemo.entity.Employee;
import com.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	@Autowired
	private EmployeeService empService;
	
	
	@GetMapping("/employees")
	public List<Employee> findAll() {
		return empService.findAll();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		
		Employee theEmp = empService.findById(employeeId);
		
		if(theEmp == null) {
			throw new RuntimeException("Employee not found : "+employeeId);
		}
		return theEmp;
		
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		
		theEmployee.setId(0);
		
		empService.save(theEmployee);
		
		return theEmployee;
		
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		
		empService.save(theEmployee);
		
		return theEmployee;
		
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		
		Employee tempEmployee = empService.findById(employeeId);
		
		if(tempEmployee == null) {
			throw new RuntimeException("Employee id not found: " +employeeId);
		}
		
		empService.delete(employeeId);
		
		return "Employee deleted Id: " +employeeId;
		
		
	}
	

}
