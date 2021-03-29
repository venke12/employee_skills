package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Address;
import com.techelevator.model.Employee;

public interface EmployeeDAO {
	
	// get a list of all employees
	List<Employee> getAllEmployees();
	
	 //create a new employee
	 Employee createEmployee(Employee employee);
	
	// get employee by id
	Employee getEmployeeById(Integer id);
	
	// update an Employee
	void updateEmployee(Integer id, Employee employee);
	
	// remove an employee
	void deleteEmployee(Integer id);

}
