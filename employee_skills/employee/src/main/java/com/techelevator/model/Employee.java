package com.techelevator.model;

import java.util.Date;

public class Employee {

	private Integer id;
	private String firstname;
	private String lastname;
	private Address address;
	private Date birthdate;
	private Date hiredate;
	private Role role;
	
	public Employee() {
		
	}
	
	public Employee(Integer id, String firstname, String lastname, 
			Address address, Date birthdate, Date hiredate, Role role) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.birthdate = birthdate;
		this.hiredate = hiredate;
		this.role = role;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
//	
//	@Override
//	public String toString() {
//		return 	"\n Employee Details" +
//				"\n ----------------" +
//				"\n Id : " + id +
//				"\n Name : " + firstname + " " + lastname +
//				"\n Address :" + address.toString() +
//				"\n Birthdate : " + birthdate + 
//				"\n Hire Date : " + hiredate +
//				"\n Role : " + role;
//	}
	
}
