package com.springboot.cruddemo.service;

import java.util.List;

import com.springboot.cruddemo.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public Employee findById(int Id);
	
	public void save(Employee employee);
	
	public void delete(int theId);

}
