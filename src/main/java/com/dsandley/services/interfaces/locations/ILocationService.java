package com.dsandley.services.interfaces.locations;

import java.util.List;

import com.dsandley.dto.general.locations.LocationDTO;
import com.dsandley.models.general.locations.Location;
import org.springframework.data.jpa.repository.Query;

public interface ILocationService {

    /**
     * Dynamic search query for locations.
     * @param name
     * @param country
     * @param state
     * @param city
     * @param zipcode
     * @return List<location> - based on the params provided
     */
    List<Location> getLocations(String name, String country, String state,
            String city, String zipcode);
    /**
     * returns back all of locations.
     * @return List<Location> - returns all of the locations
     */
    List<Location> findAll();

    Location createLocations(LocationDTO location);


}
