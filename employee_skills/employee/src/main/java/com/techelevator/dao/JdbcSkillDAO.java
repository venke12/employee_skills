package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Employee;
import com.techelevator.model.Employee_skill;
import com.techelevator.model.Skill;

@Component
public class JdbcSkillDAO implements SkillDAO{

	private JdbcTemplate jdbcTemplate;
	
	public JdbcSkillDAO(JdbcTemplate jdbctemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public List<Skill> getAllSkillsByEmployeeId(Integer employeeId) {
		List<Skill> skillList = new ArrayList<>();
		String sql = "SELECT e.id, e.firstname, e.lastname, s.id, s.name skill_name, " +
				"s.description, es.experience " + 
				"FROM employee e " + 
				"INNER JOIN employee_skill es ON e.id = es.employee_id " + 
				"INNER JOIN skill s ON  s.id = es.skill_id " + 
				"WHERE e.id = ?";
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
		if (rowSet != null) {
			while(rowSet.next()) {
				Skill skill = getSkillFromRowSet(rowSet);
				skillList.add(skill);
			}
		}
		return skillList;
	}

	// Create a new skill and add it to an existing employee, then
	// return the new skill. getAllSkillsByEmployeeId demonstrates that
	// it has been added.
//	@Override
//	public Skill createSkillByEmployeeId(Integer employeeId, Skill skill) {
//		
//		String sql_skill = "INSERT INTO skill (name, description) " + 
//				"VALUES ('.NET', '.Net Programming') " + 
//				"RETURNING id";
//		Integer new_skill_id = jdbcTemplate.queryForObject(sql_skill, Integer.class, 
//		skill.getName(), skill.getDescription());
//		skill.setId(new_skill_id);
//		String sql_addSkillToEmployee = "INSERT INTO employee_skill (employee_id, new_skill_id, experience) " + 
//				"VALUES ('?', skill_id, '24')";
//		Integer rowsUpdatedEmployee = jdbcTemplate.update(sql_addSkillToEmployee, 
//				employee_skill.getEmployee_id(), employee_skill.getSkill_id(), 
//				employee_skill.getExperience());
//		return skill;
//	}

	@Override
	public Skill getSkillByIdFromEmployeeById(Integer employeeId, Integer skillId) {
		String sql = "SELECT e.id, e.firstname, e.lastname, s.name skill_name, s.description\r\n" + 
				"FROM employee e\r\n" + 
				"INNER JOIN employee_skill es ON e.id = es.employee_id \r\n" + 
				"INNER JOIN skill s ON  s.id = es.skill_id\r\n" + 
				"WHERE e.id =? AND s.id = ?";
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
		if (rowSet != null) {
			while(rowSet.next()) {
				return getSkillFromRowSet(rowSet);
			}
		}
		return null;
	}
	
	// This is actuall an update to the employee_skill table, 
	// specifically updating experience
//	@Override
//	public Skill updateSkillByIdFromEmployeeById(Integer employeeId, Integer skillId, 
//			Employee_skill employee_skill) {
//		String sql = "UPDATE employee_skill SET experience = ? WHERE employee_id = ? AND skill_id = ?";
//		return null;
//	}

	@Override
	public void deleteSkillByIdFromEmployeeById(Integer skillId, Integer employeeId) {
		// TODO Auto-generated method stub
		
	}
	
	private Skill getSkillFromRowSet(SqlRowSet row) {
		Employee employee = new Employee();
		Skill skill = new Skill();

		employee.setId(row.getInt("id"));
		employee.setFirstname(row.getString("firstname"));
		employee.setLastname(row.getString("lastname"));
		skill.setName(row.getString("name"));
		skill.setDescription(row.getString("description"));
		
		return skill;
	}

	

}
