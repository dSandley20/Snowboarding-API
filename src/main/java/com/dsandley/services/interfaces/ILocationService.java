package com.dsandley.services.interfaces;

import java.util.List;

import com.dsandley.models.Location;

public interface ILocationService {

	/**Dynamic search query for locations.
	 * @param name
	 * @param country
	 * @param state
	 * @param city
	 * @param zipcode
	 * @return List<location> - based on the params provided
	 */
	List<Location> findAll(String name, String country,
			String state, String city, int zipcode);
}
