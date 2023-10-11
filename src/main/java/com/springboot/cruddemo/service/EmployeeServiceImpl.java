package com.springboot.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.cruddemo.dao.EmployeeDAO;
import com.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDAO empDao;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDAO empDao) {
		this.empDao = empDao;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		List<Employee> employees =  empDao.findAll();
		return employees;
	}

	@Override
	@Transactional
	public Employee findById(int Id) {
		return empDao.findById(Id);
	}

	@Override
	@Transactional
	public void save(Employee employee) {
		empDao.save(employee);

	}

	@Override
	@Transactional
	public void delete(int theId) {
		empDao.deleteById(theId);
	}

}
