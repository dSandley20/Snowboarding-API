package com.dsandley.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dsandley.models.Location;
import com.dsandley.services.LocationService;
import com.dsandley.services.UserService;

@RestController
public class LocationController {

	@Autowired
	private LocationService service;

	@GetMapping("/locations")
	public List<Location> findLocations(@RequestParam(required = false) String name,
			@RequestParam(required = false) String country, @RequestParam(required = false) String state,
			@RequestParam(required = false) String city, @RequestParam(required = false) int zipcode) {
		return service.findAll(name, country, state, city, zipcode);
	}

}
