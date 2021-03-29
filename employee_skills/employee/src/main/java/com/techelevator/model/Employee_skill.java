package com.techelevator.model;

public class Employee_skill {

	private Integer employee_id;
	private Integer skill_id;
	private Integer experience;
	
	public Employee_skill(Integer employee_id, 
			Integer skill_id, Integer experience) {
		this.employee_id = employee_id;
		this.skill_id = skill_id;
		this.experience = experience;
	}

	public Integer getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(Integer employee_id) {
		this.employee_id = employee_id;
	}

	public Integer getSkill_id() {
		return skill_id;
	}

	public void setSkill_id(Integer skill_id) {
		this.skill_id = skill_id;
	}

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}
	
	
}
