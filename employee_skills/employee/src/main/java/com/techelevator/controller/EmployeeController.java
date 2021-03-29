package com.techelevator.controller;

import java.util.List;



import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.EmployeeDAO;
import com.techelevator.model.Address;
import com.techelevator.model.Employee;

@RestController
@CrossOrigin
@RequestMapping("/employee")
public class EmployeeController {
	
	private EmployeeDAO employeeDAO;
	
	public EmployeeController(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	// get a list of all employees
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public List<Employee> getAllEmployees() {
		
		List<Employee> result = employeeDAO.getAllEmployees();
		return result;
	}
	
	// create a new employee
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(path = "/", method = RequestMethod.POST)
	public Employee createEmployee(@RequestBody Employee employee) {
			
		return employeeDAO.createEmployee(employee);	
	}
	
	// get employee by id
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public Employee getEmployeeByID(@PathVariable Integer id) {
		Employee employee = employeeDAO.getEmployeeById(id);
		return employee;
	}
	
	// update an Employee
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public void updateEmployee(@PathVariable Integer id, 
		 @RequestBody Employee employee) {
		employeeDAO.updateEmployee(id, employee);
	}
	
	// remove an employee, status ok = 200
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public void deleteEmployee(@PathVariable Integer id) {
		employeeDAO.deleteEmployee(id);
	}
	
	
}
