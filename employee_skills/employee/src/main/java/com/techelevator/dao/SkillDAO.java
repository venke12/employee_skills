package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Employee_skill;
import com.techelevator.model.Skill;

public interface SkillDAO {
	
	// Get all skills from an employee
	List<Skill> getAllSkillsByEmployeeId(Integer employeeId);
	
	// add a new skill to an employee
//	Skill createSkillByEmployeeId(Integer employeeId, 
//			Skill skill, Employee_skill employee_skill);
	
	// get a skill(id) from employee(id)
	Skill getSkillByIdFromEmployeeById(Integer skillId, 
			Integer employeeId);
	
	//update a skill(id) from employee(id)
//	Skill updateSkillByIdFromEmployeeById(Integer employeeId, 
//			Integer skillId);
	
	//delete a skill(id) from and employee(id)
	void deleteSkillByIdFromEmployeeById(Integer skillId, 
			Integer employeeId);
	
	
	
}
