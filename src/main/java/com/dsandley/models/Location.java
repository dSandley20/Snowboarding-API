/**
 * 
 */
package com.dsandley.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author danie
 * holds data such as id, name, country, state, city, and zipcode
 */
@Entity
@Table(name="locations")
public class Location {

	 @Id 	
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private int id;
	 private String name;
	 private String country;
	 private String state;
	 private String city;
	 private int zipcode;
	
	//no-args constructor
	public Location() {}
	
	//auto generated constructor using all fields
	public Location(int id, String name, String country, String state, String city, int zipcode) {
		super();
		this.id = id;
		this.name = name;
		this.country = country;
		this.state = state;
		this.city = city;
		this.zipcode = zipcode;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}
 
	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	
	
	
	
}
