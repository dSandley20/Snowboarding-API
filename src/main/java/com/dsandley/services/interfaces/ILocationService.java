package com.dsandley.services.interfaces;

import java.util.List;

import com.dsandley.models.Location;

public interface ILocationService {

	List<Location> findAll(String name, String country, String state, String city, int zipcode);
	
}
