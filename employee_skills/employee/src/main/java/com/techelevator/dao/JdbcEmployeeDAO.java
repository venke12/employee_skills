package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Address;
import com.techelevator.model.Employee;
import com.techelevator.model.Role;
import com.techelevator.model.Skill;

@Component
public class JdbcEmployeeDAO implements EmployeeDAO{

	private JdbcTemplate jdbcTemplate;
	
	public JdbcEmployeeDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employeeList = new ArrayList<>();
		String sql = "SELECT e.id, e.firstname, e.lastname, "
				+ "a.id, a.street, a.suite, a.city, a.state_region, "
				+ "a.zip, a.country, e.birthdate, e.hiredate, r.id, "
				+ "r.name, r.description "
				+ "FROM employee e "
				+ "INNER JOIN address a ON e.address_id = a.id "
				+ "INNER JOIN role r ON e.role_id = r.id";
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
		if (rowSet != null) {
			while(rowSet.next()) {
				Employee employee = getEmployeeFromRowSet(rowSet);
				employeeList.add(employee);
			}
		}
		return employeeList;
	}

	@Override
	public Employee createEmployee(Employee employee) {
				
		String sql_address = "INSERT INTO address (street, suite, city, "
				+ "state_region, zip, country)" + 
				"VALUES (?, ?, ?, ?, ?, ?)" + 
				"RETURNING id";
		Integer address_id = jdbcTemplate.queryForObject(sql_address, Integer.class, 
				employee.getAddress().getStreet(), employee.getAddress().getSuite(), 
				employee.getAddress().getCity(), employee.getAddress().getState_region(), 
				employee.getAddress().getZip(), employee.getAddress().getCountry());
		
		String sql_employee = "INSERT INTO employee (firstname, lastname, "
				+ "address_id, birthdate, hiredate, role_id) " + 
				"VALUES (?, ?, ?, ?, ?, ?) " +
				"RETURNING id";
		Integer new_employee_id = jdbcTemplate.queryForObject(sql_employee, Integer.class, 
				employee.getFirstname(), employee.getLastname(), address_id,
				employee.getBirthdate(), employee.getHiredate(), employee.getRole().getId());
		employee.setId(new_employee_id);
		return employee;
	}

	@Override
	public Employee getEmployeeById(Integer id) {
		String sql = "SELECT e.id, e.firstname, e.lastname, "
				+ "a.id, a.street, a.suite, a.city, a.state_region, "
				+ "a.zip, a.country, e.birthdate, e.hiredate, r.id, "
				+ "r.name, r.description " 
				+ "FROM employee e " 
				+ "INNER JOIN address a ON e.address_id = a.id " 
				+ "INNER JOIN role r ON e.role_id = r.id "
				+ "WHERE e.id = ?";
		
//		adds skills to the getEmployeeById, but that is taken
//		care of in JdbcSkillsDAO
//		String sql2 = "SELECT e.id, e.firstname, e.lastname, "
//				+ "a.id, a.street, a.suite, a.city, a.state_region, "
//				+ "a.zip, a.country, e.birthdate, e.hiredate, r.id, "
//				+ "r.name, r.description, s.id, s.name, s.description, "
//				+ "es.experience " + 
//				"FROM employee e " + 
//				"INNER JOIN address a ON e.address_id = a.id " + 
//				"INNER JOIN role r ON e.role_id = r.id " + 
//				"INNER JOIN employee_skill es ON e.id = es.employee_id " + 
//				"INNER JOIN skill s ON s.id = es.skill_id " + 
//				"WHERE e.id = ?";
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, id);
		if (rowSet != null) {
			while(rowSet.next()) {
				return getEmployeeFromRowSet(rowSet);
			}
		}
		return null;
	}

	@Override
	public void updateEmployee(Integer id, Employee employee) {
//	may want a separate updateEmployeeAddress
//		String sql_address = "UPDATE address SET street = ?, suite = ?, "
//				+ "city = ?, state_region = ?, zip = ?, country = ? "
//				+ "WHERE id = ?";
//		Integer rowsUpdatedAddress = jdbcTemplate.update(sql_address, 
//				address.getStreet(), address.getSuite(), address.getCity(), 
//				address.getState_region(), address.getZip(), 
//				address.getCountry());
		String sql_employee = "UPDATE employee SET firstname = ?, "
				+ "lastname = ?, address_id = ?, birthdate = ? , "
				+ "hiredate = ?, role_id = ? WHERE id = ?";
		Integer rowsUpdatedEmployee = jdbcTemplate.update(sql_employee, 
				employee.getFirstname(), employee.getLastname(),
				employee.getAddress(), employee.getBirthdate(),
				employee.getHiredate(), employee.getRole());
		//System.out.println("rowsUpdated: " + rowsUpdated);
		
	}

	@Override
	public void deleteEmployee(Integer id) {
		String sql_address = "SELECT address_id FROM employee WHERE id = ?";
		Integer address_id = jdbcTemplate.queryForObject(sql_address, Integer.class);
		String sql_address_delete = "DELETE FROM address WHERE id = " + address_id;
		String sql_employee_delete = "DELETE FROM employee WHERE id = ?";
		jdbcTemplate.update(sql_address_delete);
		jdbcTemplate.update(sql_employee_delete);
	}
	
	private Employee getEmployeeFromRowSet(SqlRowSet row) {
		Employee employee = new Employee();
		
		Address address = new Address(row.getInt("id"), row.getString("street"), 
				row.getString("suite"), row.getString("city"), 
				row.getString("state_region"), row.getString("zip"),
				row.getString("country"));
		
		Role role = new Role(row.getInt("id"), row.getString("name"), 
				row.getString("description"));
		
		employee.setId(row.getInt("id"));
		employee.setFirstname(row.getString("firstname"));
		employee.setLastname(row.getString("lastname"));
		employee.setAddress(address);
		employee.setBirthdate(row.getDate("birthdate"));
		employee.setHiredate(row.getDate("hiredate"));
		employee.setRole(role);
		
		return employee;
	}
	
	
	

}
