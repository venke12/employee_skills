package com.techelevator.model;


// check for validation constraints

public class Address {

	private Integer id;
	private String street;
	private String suite;
	private String city;
	private String state_region;
	private String zip;
	private String country;
	
	public Address() {
		
	}
	
	public Address(Integer id, String street, String suite, 
			String city, String state_region, 
			String zip, String country) {
		this.id = id;
		this.street = street;
		this.suite = suite;
		this.city = city;
		this.state_region = state_region;
		this.zip = zip;
		this.country = country;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getSuite() {
		return suite;
	}

	public void setSuite(String suite) {
		this.suite = suite;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState_region() {
		return state_region;
	}

	public void setState_region(String state_region) {
		this.state_region = state_region;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	@Override
	public String toString() {
		return 	"Address" +
				"\n ----------------" +
				"\n id= " + id +
				"\n" + street +
				"\n" + city + ", " + state_region + " " + zip +
				"\n" + country;		
	}
	
}
