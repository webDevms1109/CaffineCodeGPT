package com.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.springboot.cruddemo.entity.Employee;

@Repository
@Primary
public class EmployeeDAOJPAImpl implements EmployeeDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOJPAImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAll() {
		Query theQuery = entityManager.createQuery("from Employee");
		
		List<Employee> employees = theQuery.getResultList();
		return employees;
	}

	@Override
	public Employee findById(int theEmp) {
		Employee empl = entityManager.find(Employee.class, theEmp);
		return empl;
	}

	@Override
	public void save(Employee theEmp) {
		
		Employee dbEmployee = entityManager.merge(theEmp);
		
		theEmp.setId(dbEmployee.getId());

	}

	@Override
	public void deleteById(int theEmp) {
		Query theQuery = entityManager.createQuery("delete from Employee where id =:employeeId");
		
		theQuery.setParameter("employeeId", theEmp);
		
		theQuery.executeUpdate();

	}

}
