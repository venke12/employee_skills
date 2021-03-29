package com.techelevator.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.EmployeeDAO;
import com.techelevator.dao.SkillDAO;
import com.techelevator.model.Skill;

@RestController
@CrossOrigin
@RequestMapping("/employee/{id}")
public class SkillController {

	private EmployeeDAO employeeDAO;
	private SkillDAO skillDAO;
	
	public SkillController(EmployeeDAO employeeDAO,
			SkillDAO skillDAO) {
		this.employeeDAO = employeeDAO;
		this.skillDAO = skillDAO;
	}
	
	// Get all skills from an employee
	@RequestMapping(path = "/skill", method = RequestMethod.GET)
	public List<Skill> getAllSkillsByEmployeeId(Integer employeeId) {
		List<Skill> result = skillDAO.getAllSkillsByEmployeeId(employeeId);
		return result;
	}
	
//	// add a new skill to an employee
//	@RequestMapping(path = "/", method = RequestMethod.POST)
//	public Skill createSkillByEmployeeId(@RequestParam Integer employeeId, 
//			@RequestParam Skill skill) {
//		return skillDAO.createSkillByEmployeeId(employeeId, skill);
//	}
	
	// get a skill(id) from employee(id)
	@RequestMapping(path = "/skill/{id}", method = RequestMethod.GET)
	public Skill getSkillByIdFromEmployeeById(@RequestParam Integer skillId, 
			@RequestParam Integer employeeId) {
		Skill skill = skillDAO.getSkillByIdFromEmployeeById(skillId, employeeId);
		return skill;
	}
	
	//update a skill(id) from employee(id)
//	@RequestMapping(path = "/skill/{id}", method = RequestMethod.PUT)
//	public void updateSkillByIdFromEmployeeById(@PathVariable Integer employeeId, 
//			@PathVariable Integer skillId) {
//		skillDAO.updateSkillByIdFromEmployeeById(employeeId, skillId);
//	}
	
	//delete a skill(id) from and employee(id)
	@RequestMapping(path = "/skill/{id}", method = RequestMethod.DELETE)
	public void deleteSkillByIdFromEmployeeById(@PathVariable Integer skillId, 
			@PathVariable Integer employeeId) {
		skillDAO.deleteSkillByIdFromEmployeeById(skillId, employeeId);
	}
}
